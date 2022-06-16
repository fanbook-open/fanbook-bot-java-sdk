package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.UserResponse;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户登陆
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginApi extends FanbookRestfulApi<UserResponse> {

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("device")
    private String device;

    @SerializedName("code")
    private String code;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "open/api/user/login";
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
    public Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == mobile || mobile.isEmpty()) {
            throw new BotArgumentException("mobile must not be null");
        }
        if (null == device || device.isEmpty()) {
            throw new BotArgumentException("device must not be null");
        }
        if (null == code || code.isEmpty()) {
            throw new BotArgumentException("code must not be null");
        }
    }
}
