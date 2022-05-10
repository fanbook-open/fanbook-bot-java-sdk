package com.idreamsky.fanbook.sdk;

import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Fanbook使用restful风格编写的接口
 *
 * @author peng.gan
 */
@Slf4j
public abstract class FanbookRestfulApi<T extends Serializable> extends BotMethod<T> {


    /**
     * 获取响应实体类的class；
     * PS：注意不要使用带泛型的实体类T
     *
     * @return
     */
    public abstract Class<T> getResponseClass();

    @Override
    public T parseResponse(String responseBody) {
        if (String.class.isAssignableFrom(getResponseClass())) {
            return (T) responseBody;
        }
        return gson.fromJson(responseBody, getResponseClass());
    }



    /**
     * 自定义构建URL
     *
     * @param clientProfile
     * @return
     */
    @Override
    protected String buildUrl(ClientProfile clientProfile) {
        return String.format("%s://%s/%s", clientProfile.getHttpProtocolType(), clientProfile.getDomain(), getEndpoint());
    }
}
