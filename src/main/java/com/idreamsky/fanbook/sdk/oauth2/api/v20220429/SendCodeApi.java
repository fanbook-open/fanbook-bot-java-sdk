package com.idreamsky.fanbook.sdk.oauth2.api.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.FanbookRestfulApi;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.SendCodeResponse;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 发送短信验证码
 *
 * @author peng.gan
 */
@Data
@Slf4j
public class SendCodeApi extends FanbookRestfulApi<SendCodeResponse> {

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("device")
    private String device;

    @SerializedName("area_code")
    private String areaCode = "+86";

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "open/api/user/sendCode";
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
    public Class<SendCodeResponse> getResponseClass() {
        return SendCodeResponse.class;
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
        if (null == areaCode || areaCode.isEmpty()) {
            throw new BotArgumentException("areaCode must not be null");
        }
    }
}
