package com.idreamsky.fanbook.sdk;

import com.google.gson.Gson;
import com.idreamsky.fanbook.sdk.exception.BotClientException;
import com.idreamsky.fanbook.sdk.exception.BotRemoteServerException;
import com.idreamsky.fanbook.sdk.http.*;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * 默认的Fanbook API client
 *
 * @author peng.gan
 */
@Slf4j
public class DefaultFanbookBotClient implements IFanbookBotClient {

    private ClientProfile clientProfile;

    private HttpClientAdapter httpClient;

    private HttpClientAdapter longPollingHttpClient;

    private CircuitBreakerFactory circuitBreakerFactory;

    public DefaultFanbookBotClient(ClientProfile clientProfile) {
        clientProfile.validate();
        this.clientProfile = clientProfile;
        this.httpClient = HttpClientFactory.create(this.clientProfile.getHttpConfig());
        HttpConfig updatesHttpConfig = new HttpConfig();
        updatesHttpConfig.setSocketTimeout(120 * 1000);
        this.longPollingHttpClient = HttpClientFactory.create(updatesHttpConfig);
        circuitBreakerFactory = new CircuitBreakerFactory(clientProfile.getCircuitBreakerConfig());
    }


    @Override
    public <T extends Serializable> T getBotResponse(BotMethod<T> botMethod) {
        HttpResponse httpResponse = this.invoke(botMethod);
        if (httpResponse.getStatus() != HttpStatus.SC_OK) {
            log.error("Fanbook bot 响应结果失败，HttpResponse:{}", new Gson().toJson(httpResponse));
            throw new BotClientException("Server internal error");
        }
        return this.parseBotResponse(botMethod, httpResponse);
    }

    private <T extends Serializable> T parseBotResponse(BotMethod<T> botMethod, HttpResponse httpResponse) {
        if (log.isInfoEnabled()) {
            log.info("Bot [{}] api response is :{}", botMethod.getClass().getSimpleName(), httpResponse.getResponseBody());
        }
        return botMethod.parseResponse(httpResponse.getResponseBody());
    }


    /**
     * 请求Http接口
     *
     * @param botMethod 机器人接口方法
     * @return HttpResponse http标准的响应实体类
     */
    @Override
    public <T extends Serializable> HttpResponse invoke(BotMethod<T> botMethod) {
        HttpRequest httpRequest = botMethod.toHttpRequest(clientProfile);
        botMethod.validate();
        String name = String.format("%s:%s", httpRequest.getHttpMethodType().name(), httpRequest.getUrl());
        CircuitBreaker circuitBreaker = circuitBreakerFactory.getCircuitBreaker(name);
        CheckedFunction0<HttpResponse> httpResponseCheckedFunction0 = CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> doInvoke(httpRequest));
        return Try.of(httpResponseCheckedFunction0).recover(CallNotPermittedException.class,
                throwable -> {
                    log.error("Fanbook Bot api 【{}】不可用, 已触发熔断, err:{}", name, throwable.getMessage(), throwable);
                    throw new BotRemoteServerException("Fanbook服务器暂时不可用，请稍后再试");
                }).get();
    }

    /**
     * 标准的请求Http接口
     *
     * @param httpRequest Http请求实体类
     * @return HttpResponse 响应实体类
     */
    @Override
    public <T extends Serializable> HttpResponse doInvoke(HttpRequest httpRequest) {
        if (httpRequest.getLongPooling()) {
            return longPollingHttpClient.doInvoke(httpRequest);
        } else {
            return httpClient.doInvoke(httpRequest);
        }
    }


}
