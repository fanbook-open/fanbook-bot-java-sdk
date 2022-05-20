package com.idreamsky.fanbook.sdk;

import com.google.gson.Gson;
import com.idreamsky.fanbook.sdk.exception.BotClientException;
import com.idreamsky.fanbook.sdk.http.HttpClientAdapter;
import com.idreamsky.fanbook.sdk.http.HttpClientFactory;
import com.idreamsky.fanbook.sdk.http.HttpRequest;
import com.idreamsky.fanbook.sdk.http.HttpResponse;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
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

    public DefaultFanbookBotClient(ClientProfile clientProfile) {
        clientProfile.validate();
        this.clientProfile = clientProfile;
        this.httpClient = HttpClientFactory.create(this.clientProfile);
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
        log.info("Bot [{}] api response is :{}", botMethod.getClass().getSimpleName(), httpResponse.getResponseBody());
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
        return this.doInvoke(httpRequest);
    }

    /**
     * 标准的请求Http接口
     *
     * @param httpRequest Http请求实体类
     * @return HttpResponse 响应实体类
     */
    @Override
    public <T extends Serializable> HttpResponse doInvoke(HttpRequest httpRequest) {
        return httpClient.doInvoke(httpRequest);
    }

}
