package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.TokenResponse;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshApi extends FanbookRestfulApi<TokenResponse> {

    @SerializedName("grant_type")
    private String grantType = "refresh_token";

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("redirect_uri")
    private String redirectUri;


    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "open/oauth2/refresh";
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
        if (null == grantType || grantType.isEmpty()) {
            throw new BotArgumentException("grantType must no be null");
        }
        if (null == refreshToken || refreshToken.isEmpty()) {
            throw new BotArgumentException("refreshToken must no be null");
        }
        if (null == redirectUri || redirectUri.isEmpty()) {
            throw new BotArgumentException("redirectUri must no be null");
        }
    }
}
