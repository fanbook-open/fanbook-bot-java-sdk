package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 发送通知
 *
 * @author peng.gan
 */
@Data
@Slf4j
// FIXME 接口调不通
public class SendNoticationMethod extends BotMethod {

    @SerializedName("channel_type")
    private String channelType;

    @SerializedName("to_user_id")
    private String toUserId;

    @SerializedName("content")
    private String content;

    @SerializedName("nonce")
    private String nonce;

    @SerializedName("extra")
    private String extra;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "sendNotication";
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
     * 使用指定的泛型实体类T解析response body
     *
     * @param responseBody http response body
     * @return 反序列化类型T对应的实体类
     */
    @Override
    public Serializable parseResponse(String responseBody) throws BotApiRequestException {
        return responseBody;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {

    }
}
