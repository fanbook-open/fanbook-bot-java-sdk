package com.idreamsky.fanbook.sdk;

import com.idreamsky.fanbook.sdk.http.HttpRequest;
import com.idreamsky.fanbook.sdk.http.HttpResponse;

import java.io.Serializable;

/**
 * @author peng.gan
 */
public interface IFanbookBotClient {

    /**
     * 获取机器人的响应数据
     *
     * @param botMethod 具体的接口请求
     * @param <T> response body需要反序列化的泛型T
     * @return T 泛型T对应的对象
     */
    <T extends Serializable> T getBotResponse(BotMethod<T> botMethod);

    /**
     * 请求Http接口
     *
     * @param botMethod 具体的接口请求
     * @param <T> response body需要反序列化的泛型T
     * @return HttpResponse
     */
    <T extends Serializable> HttpResponse invoke(BotMethod<T> botMethod);

    /**
     * 标准的请求Http接口
     * @param httpRequest HttpRequest请求对象
     * @param <T> response body需要反序列化的泛型T
     * @return HttpResponse
     */
    <T extends Serializable> HttpResponse doInvoke(HttpRequest httpRequest);
}
