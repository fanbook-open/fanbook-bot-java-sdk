package com.idreamsky.fanbook.sdk.http;

import lombok.SneakyThrows;
import org.apache.http.Consts;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.auth.*;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author peng.gan
 */

public class HttpClientFactory {

    private static Logger logger = LoggerFactory.getLogger(HttpClientFactory.class);

    public static HttpClientAdapter create(HttpConfig httpConfig) {
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
                //关闭s空闲的连接
                manager.closeIdleConnections(httpConfig.getMaxIdleTimeMillis(), TimeUnit.MILLISECONDS);
                if (logger.isDebugEnabled()) {
                    logger.debug("close expired and idle for over {}s connection", httpConfig.getMaxIdleTimeMillis() / 1000);
                }
            }
        }, 30 * 1000, 30 * 1000, TimeUnit.MILLISECONDS);
        final int maxRetryCount = httpConfig.getMaxRetryCount();
        HttpRequestRetryHandler httpRequestRetryHandler = (e, i, httpContext) -> {
            if (i > maxRetryCount) {
                //重试超过{maxRetryCount}次,放弃请求
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

    @SneakyThrows
    public static HttpClientAdapter createAsyncClient(HttpConfig httpConfig)  {
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setConnectTimeout(httpConfig.getConnectTimeout())
                .setSocketTimeout(httpConfig.getSocketTimeout()).build();
        SSLContext sslcontext = SSLContexts.createDefault();

        Registry<SchemeIOSessionStrategy> sessionStrategyRegistry = RegistryBuilder
                .<SchemeIOSessionStrategy> create()
                .register("http", NoopIOSessionStrategy.INSTANCE)
                .register("https", new SSLIOSessionStrategy(sslcontext))
                .build();

        IOReactorConfig ioReactorConfig = IOReactorConfig.custom().setSoKeepAlive(false).setTcpNoDelay(true)
                .setIoThreadCount(Runtime.getRuntime().availableProcessors())
                .build();

        ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
        PoolingNHttpClientConnectionManager connectionManager = new PoolingNHttpClientConnectionManager(
                ioReactor, null, sessionStrategyRegistry, null);
        connectionManager.setDefaultMaxPerRoute(httpConfig.getMaxRoute());
        connectionManager.setMaxTotal(httpConfig.getMaxConn());
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8).build();

        Lookup<AuthSchemeProvider> authSchemeRegistry = RegistryBuilder
                .<AuthSchemeProvider> create()
                .register(AuthSchemes.BASIC, new BasicSchemeFactory())
                .register(AuthSchemes.DIGEST, new DigestSchemeFactory())
                .register(AuthSchemes.NTLM, new NTLMSchemeFactory())
                .register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory())
                .register(AuthSchemes.KERBEROS, new KerberosSchemeFactory())
                .build();
        connectionManager.setDefaultConnectionConfig(connectionConfig);

        return new HttpClientAdapter(HttpAsyncClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultAuthSchemeRegistry(authSchemeRegistry)
                .setDefaultCookieStore(new BasicCookieStore()).build());
    }

}
