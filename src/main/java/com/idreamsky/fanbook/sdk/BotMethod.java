package com.idreamsky.fanbook.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.http.HttpRequest;
import com.idreamsky.fanbook.sdk.interfaces.Validable;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Fanbook机器人的API的聚合对象
 *
 * @author peng.gan
 */
@Slf4j
public abstract class BotMethod<T extends Serializable> implements Validable {

    protected final static String BOT_TOKEN_PLACE_HOLDER = "{bot_token}";

    protected final static String HEADER_AUTHORIZATION = "authorization";

    protected final static String HEADER_AUTHORIZATION_PREFIX = "Bearer ";

    protected final static String HEADER_TOKEN_PREFIX = "Basic ";

    protected final static Gson gson = new GsonBuilder().create();

    @Getter
    protected transient Map<String, String> headers = new HashMap<>();

    @Getter
    protected transient Map<String, String> uriVariables = new HashMap<>();


    /**
     * 获取接口的端点
     *
     * @return string
     */
    protected abstract String getEndpoint();


    /**
     * Fanbook bot api的接口的请求方式
     *
     * @return HttpMethodType
     */
    protected abstract HttpMethodType getHttpMethodType();


    protected void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    protected void addUriVariables(String key, String value) {
        this.uriVariables.put(key, value);
    }

    public HttpRequest toHttpRequest(@NonNull ClientProfile clientProfile) {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setHttpMethodType(getHttpMethodType());
        httpRequest.setUrl(this.buildUrl(clientProfile));
        httpRequest.setUriVariables(this.buildUriVariables(clientProfile));
        httpRequest.setHeaders(this.buildHeader(clientProfile));
        httpRequest.setBody(this.buildBody(clientProfile));
        if (log.isInfoEnabled()) {
            log.info("[{}] api request is:{}", this.getClass().getSimpleName(), gson.toJson(httpRequest));
        }
        return httpRequest;
    }


    /**
     * 使用指定的泛型实体类T解析response body
     *
     * @param responseBody http response body
     * @return 反序列化类型T对应的实体类
     */
    public abstract T parseResponse(String responseBody) throws BotApiRequestException;

    /**
     * 根据数据传递格式，构造request body
     * @param clientProfile 客户端环境
     * @return request body的字符串形式
     */
    protected String buildBody(ClientProfile clientProfile) {
        return gson.toJson(this);
    }

    /**
     * 自定义构建请求头
     *
     * @param clientProfile 客户端环境
     * @return k-v形式的header集合
     */
    protected Map<String, String> buildHeader(ClientProfile clientProfile) {
        this.addHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        return headers;
    }

    /**
     * 自定义构建URL变量
     *
     * @param clientProfile 客户端环境
     * @return k-v形式的URL变量集合
     */
    protected Map<String, String> buildUriVariables(ClientProfile clientProfile) {
        return this.uriVariables;
    }

    /**
     * 自定义构建URL
     *
     * @param clientProfile 客户端环境
     * @return 字符串格式的URL
     */
    protected String buildUrl(ClientProfile clientProfile) {
        String url = String.format("%s://%s/api/bot/{bot_token}/%s", clientProfile.getHttpProtocolType(), clientProfile.getDomain(), getEndpoint());
        if (url.contains(BOT_TOKEN_PLACE_HOLDER)) {
            url = url.replace(BOT_TOKEN_PLACE_HOLDER, clientProfile.getBotToken());
        }
        return url;
    }


    protected String buildAuthorizationHeader(String clientKey, String clientSecret) {
        String base64String = clientKey + ":" + clientSecret;
        return Base64.getMimeEncoder().encodeToString(base64String.getBytes(StandardCharsets.UTF_8));
    }
}
