package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.AppResponse;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import lombok.Data;

import java.util.Map;


/**
 * @author peng.gan
 */
@Data
public class AppApi extends FanbookRestfulApi<AppResponse> {

    /**
     * 注意，这里传递的是Fanbook 客户端使用的用户token
     *
     * @param authorizationOfFanbookClient 客户端使用的用户token
     */
    public void addAuthorization(String authorizationOfFanbookClient) {
        super.addHeader(HEADER_AUTHORIZATION, authorizationOfFanbookClient);
    }

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("redirect_url")
    private String redirectUrl;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "open/oauth2/app";
    }

    /**
     * Fanbook bot api的接口的请求方式
     *
     * @return HttpMethodType
     */
    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.GET;
    }

    /**
     * 获取响应实体类的class；
     * PS：注意不要使用带泛型的实体类T
     *
     * @return T
     */
    @Override
    public Class<AppResponse> getResponseClass() {
        return AppResponse.class;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == clientId || clientId.isEmpty()) {
            throw new BotArgumentException("clientId must not be null");
        }
        if (null == headers.get(HEADER_AUTHORIZATION) || headers.get(HEADER_AUTHORIZATION).isEmpty()) {
            throw new BotArgumentException("authorization of Fanbook Client must not be null");
        }
    }

    /**
     * 根据数据传递格式，构造request body
     *
     * @param clientProfile 客户端环境
     * @return 字符串格式的http request body
     */
    @Override
    protected String buildBody(ClientProfile clientProfile) {
        return null;
    }


    /**
     * 自定义构建URL变量
     *
     * @param clientProfile 客户端环境
     * @return k-v形式的URL变量集合
     */
    @Override
    protected Map<String, String> buildUriVariables(ClientProfile clientProfile) {
        this.clientId = clientProfile.getClientKey();
        this.addUriVariables("client_id", clientId);
        this.addUriVariables("redirect_url", redirectUrl);
        return super.uriVariables;
    }
}
