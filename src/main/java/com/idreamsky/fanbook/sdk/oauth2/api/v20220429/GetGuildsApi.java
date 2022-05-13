package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.GuildsResponse;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import lombok.Data;

/**
 * 获取个人服务器列表
 *
 * @author peng.gan
 */
@Data
public class GetGuildsApi extends FanbookRestfulApi<GuildsResponse> {

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
        return "open/api/guild/getGuilds";
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
    public Class<GuildsResponse> getResponseClass() {
        return GuildsResponse.class;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == super.getHeaders().get(HEADER_AUTHORIZATION) || super.getHeaders().get(HEADER_AUTHORIZATION).isEmpty()) {
            throw new BotArgumentException("accessToken of request header must not be null");
        }
    }
}
