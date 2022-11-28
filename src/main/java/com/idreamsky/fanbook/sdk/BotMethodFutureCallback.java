package com.idreamsky.fanbook.sdk;

import com.google.gson.Gson;
import com.idreamsky.fanbook.sdk.exception.BotClientException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
public abstract class BotMethodFutureCallback implements FutureCallback<HttpResponse> {

    private BotMethod botMethod;


    public BotMethodFutureCallback(BotMethod botMethod) {
        this.botMethod = botMethod;
    }

    @Override
    public void completed(final HttpResponse httpResponse) {
        com.idreamsky.fanbook.sdk.http.HttpResponse httpContent = this.getHttpContent(httpResponse);
        if (log.isInfoEnabled()) {
            log.info("Bot [{}] api response is :{}", botMethod.getClass().getSimpleName(), httpContent.getResponseBody());
        }
        if (httpContent.getStatus() != HttpStatus.SC_OK) {
            log.error("Fanbook bot 【{}】响应结果失败，HttpResponse:{}", botMethod.getClass().getSimpleName(), new Gson().toJson(httpResponse));
            throw new BotClientException("Server internal error");
        }
        Serializable serializable = botMethod.parseResponse(httpContent.getResponseBody());
        this.getBotMethodResponse(serializable);
    }

    protected abstract void getBotMethodResponse(Serializable serializable);

    @Override
    public void failed(Exception e) {

    }

    @Override
    public void cancelled() {

    }

    protected com.idreamsky.fanbook.sdk.http.HttpResponse getHttpContent(HttpResponse remoteResponse) {
        try {
            com.idreamsky.fanbook.sdk.http.HttpResponse httpResponse = new com.idreamsky.fanbook.sdk.http.HttpResponse();
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


}
