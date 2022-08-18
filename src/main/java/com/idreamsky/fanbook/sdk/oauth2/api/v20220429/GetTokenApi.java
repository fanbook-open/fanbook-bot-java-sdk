package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.TokenResponse;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;

import java.util.Map;

/**
 * oauth2接口：使用code换发token
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTokenApi extends FanbookRestfulApi<TokenResponse> {

    @Builder.Default
    @SerializedName("grant_type")
    private String grantType = "authorization_code";

    @SerializedName("code")
    private String code;

    @SerializedName("redirect_uri")
    private String redirectUri;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "open/oauth2/token";
    }

    /**
     * Fanbook bot api的接口的请求方式
     *
     * @return HttpMethodType
     */
    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.POST;
    }

    /**
     * 获取响应实体类的class；
     * PS：注意不要使用带泛型的实体类T
     *
     * @return T
     */
    @Override
    public Class<TokenResponse> getResponseClass() {
        return TokenResponse.class;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == code || code.isEmpty()) {
            throw new BotArgumentException("code must no be null");
        }
        if (null == grantType || grantType.isEmpty()) {
            throw new BotArgumentException("grantType must no be null");
        }
        if (null == redirectUri || redirectUri.isEmpty()) {
            throw new BotArgumentException("redirectUri must no be null");
        }
    }

    /**
     * 根据数据传递格式，构造request body
     *
     * @return request body的字符串形式
     */
    @Override
    public String buildBody(ClientProfile clientProfile) {
        return String.format("grant_type=%s&code=%s&redirect_uri=%s", grantType, code, redirectUri);
    }

    @Override
    protected Map<String, String> buildHeader(ClientProfile clientProfile) {
        String authorization = super.buildAuthorizationHeader(clientProfile.getClientKey(), clientProfile.getClientSecret());
        super.headers.put(HEADER_AUTHORIZATION, HEADER_TOKEN_PREFIX + authorization);
        super.headers.put(HTTP.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
        return super.getHeaders();
    }
}
