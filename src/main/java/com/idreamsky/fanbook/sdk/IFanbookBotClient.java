package com.idreamsky.fanbook.sdk;

import com.idreamsky.fanbook.sdk.http.HttpRequest;
import com.idreamsky.fanbook.sdk.http.HttpResponse;
import lombok.NonNull;
import org.apache.http.concurrent.FutureCallback;

import java.io.Serializable;

/**
 * @author peng.gan
 */
public interface IFanbookBotClient {

    /**
     * 获取机器人的响应数据
     *
     * @param botMethod 具体的接口请求
     * @param <T>       response body需要反序列化的泛型T
     * @return T 泛型T对应的对象
     */
    <T extends Serializable> T getBotResponse(@NonNull BotMethod<T> botMethod);

    /**
     * 异步调用接口
     * @param botMethod 方法
     * @param callback 回调函数
     * @param <T> 泛型
     */
    <T extends Serializable> void getBotResponseFuture(@NonNull BotMethod<T> botMethod, FutureCallback<org.apache.http.HttpResponse> callback);

    /**
     * 请求Http接口
     *
     * @param botMethod 具体的接口请求
     * @param <T>       response body需要反序列化的泛型T
     * @return HttpResponse
     */
    <T extends Serializable> HttpResponse invoke(BotMethod<T> botMethod);

    /**
     * 标准的请求Http接口
     *
     * @param httpRequest HttpRequest请求对象
     * @param <T>         response body需要反序列化的泛型T
     * @return HttpResponse
     */
    <T extends Serializable> HttpResponse doInvoke(HttpRequest httpRequest);
}
