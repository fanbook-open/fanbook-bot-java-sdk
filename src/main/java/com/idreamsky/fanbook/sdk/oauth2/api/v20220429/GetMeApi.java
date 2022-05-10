package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.UserResponse;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import lombok.Data;

@Data
public class GetMeApi extends FanbookRestfulApi<UserResponse> {

    public void setAccessToken(String accessToken) {
        super.addHeader(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_PREFIX + accessToken);
    }

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "open/api/user/getMe";
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
     * @return
     */
    @Override
    public Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == super.getHeaders().get(HEADER_AUTHORIZATION) || super.getHeaders().get(HEADER_AUTHORIZATION).isEmpty()) {
            throw new BotArgumentException("accessToken of request header must not be null");
        }
    }
}
