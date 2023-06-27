package com.idreamsky.fanbook.sdk.http;

import com.google.gson.Gson;
import com.idreamsky.fanbook.sdk.exception.BotClientException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.Future;

/**
 * http client客户端适配器
 *
 * @author peng.gan
 */
@Slf4j
public class HttpClientAdapter {

    private CloseableHttpClient httpClient;
    private CloseableHttpAsyncClient httpAsyncClient;

    public HttpClientAdapter(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpClientAdapter(CloseableHttpAsyncClient httpClient) {
        this.httpAsyncClient = httpClient;
    }


    public HttpResponse doInvoke(HttpRequest httpRequest) {
        HttpUriRequest httpUriRequest = this.buildHttpUriRequest(httpRequest);
        try (CloseableHttpResponse remoteResponse = httpClient.execute(httpUriRequest)) {
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setStatus(remoteResponse.getStatusLine().getStatusCode());
            String result = EntityUtils.toString(remoteResponse.getEntity(), "UTF-8");
            httpResponse.setResponseBody(result);
            Map headerMap = new HashMap<>();
            Arrays.stream(remoteResponse.getAllHeaders()).forEach(e -> headerMap.put(e.getName(), e.getValue()));
            httpResponse.setHeaders(headerMap);
            return httpResponse;
        } catch (Exception e) {
            throw new BotClientException(e.getMessage(), e);
        }
    }

    private HttpUriRequest buildHttpUriRequest(HttpRequest httpRequest) {
        RequestBuilder requestBuilder = RequestBuilder.create(httpRequest.getHttpMethodType().name());
        requestBuilder.setUri(httpRequest.getUrl());
        if (null != httpRequest.getHeaders() && httpRequest.getHeaders().size() > 0) {
            httpRequest.getHeaders().forEach(requestBuilder::addHeader);
        }
        if (null != httpRequest.getBody() && httpRequest.getBody().length() > 0) {
            boolean isForm = httpRequest.getHeaders().get(HTTP.CONTENT_TYPE).contains(ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
            StringEntity httpEntity = null;
            if (isForm) {
                List<NameValuePair> nameValuePairList = new ArrayList<>();
                Arrays.stream(httpRequest.getBody().split("&")).forEach(e -> {
                    int index = e.indexOf("=");
                    String key = e.substring(0, index);
                    String value = e.substring(index + 1);
                    nameValuePairList.add(new BasicNameValuePair(key, value));
                });
                try {
                    httpEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
                } catch (Exception e) {
                    log.error("format body to form fail, e:{}", e.getMessage(), e);
                    throw new BotClientException("format body to form fail", e);
                }
            } else {
                httpEntity = new StringEntity(httpRequest.getBody(), ContentType.APPLICATION_JSON);
            }
            requestBuilder.setEntity(httpEntity);
        }
        if (null != httpRequest.getUriVariables() && !httpRequest.getUriVariables().isEmpty()) {
            httpRequest.getUriVariables().forEach(requestBuilder::addParameter);
        }
        return requestBuilder.build();
    }

    @SneakyThrows
    public void doInvokeFuture(HttpRequest httpRequest, FutureCallback<org.apache.http.HttpResponse> callback) {
        HttpUriRequest httpUriRequest = this.buildHttpUriRequest(httpRequest);
        if (!httpAsyncClient.isRunning()) {
            httpAsyncClient.start();
        }
        Future<org.apache.http.HttpResponse> execute = httpAsyncClient.execute(httpUriRequest, callback);
    }
}
