package com.idreamsky.fanbook.sdk.http;

import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author peng.gan
 */

public class HttpClientFactory {

    private static Logger logger = LoggerFactory.getLogger(HttpClientFactory.class);

    public static HttpClientAdapter create(ClientProfile clientProfile) {
        HttpConfig httpConfig = clientProfile.getHttpConfig();
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setDefaultMaxPerRoute(httpConfig.getMaxRoute());
        manager.setMaxTotal(httpConfig.getMaxConn());

        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setConnectTimeout(httpConfig.getConnectTimeout())
                .setSocketTimeout(httpConfig.getSocketTimeout()).build();

        ScheduledExecutorService monitorExecutor = Executors.newSingleThreadScheduledExecutor();
        monitorExecutor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //关闭异常连接
                manager.closeExpiredConnections();
                //关闭5s空闲的连接
                manager.closeIdleConnections(httpConfig.getMaxIdleTimeMillis(), TimeUnit.MILLISECONDS);
                logger.info("close expired and idle for over 5s connection");
            }
        }, 30 * 1000, 30 * 1000, TimeUnit.MILLISECONDS);
        final int maxRetryCount = httpConfig.getMaxRetryCount();
        HttpRequestRetryHandler httpRequestRetryHandler = (e, i, httpContext) -> {
            if (i > maxRetryCount) {
                //重试超过3次,放弃请求
                logger.error("retry has more than {} time, give up request", maxRetryCount);
                return false;
            }
            if (e instanceof NoHttpResponseException) {
                //服务器没有响应,可能是服务器断开了连接,应该重试
                logger.error("receive no response from server, retry");
                return true;
            }
            if (e instanceof SSLHandshakeException) {
                // SSL握手异常
                logger.error("SSL hand shake exception");
                return false;
            }
            if (e instanceof InterruptedIOException) {
                //超时
                logger.error("InterruptedIOException");
                return false;
            }
            if (e instanceof UnknownHostException) {
                // 服务器不可达
                logger.error("server host unknown");
                return false;
            }
            if (e instanceof ConnectTimeoutException) {
                // 连接超时
                logger.error("Connection Time out");
                return false;
            }
            if (e instanceof SSLException) {
                logger.error("SSLException");
                return false;
            }

            HttpClientContext context = HttpClientContext.adapt(httpContext);
            HttpRequest request = context.getRequest();
            if (!(request instanceof HttpEntityEnclosingRequest)) {
                //如果请求不是关闭连接的请求
                return true;
            }
            return false;
        };
        return new HttpClientAdapter(HttpClients.custom()
                .setConnectionManager(manager)
                .setDefaultRequestConfig(globalConfig)
                .setConnectionManagerShared(true)
                .setRetryHandler(httpRequestRetryHandler)
                .build());
    }
}
