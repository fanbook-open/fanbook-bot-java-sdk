package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.model.RestResponse;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * 设置机器人是否工作在privacy模式
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetBotPrivacyModeMethod extends BotMethod<Serializable> {

    public void setAuthorization(String authorizationOfFanbookClient) {
        super.addHeader(HEADER_AUTHORIZATION, authorizationOfFanbookClient);
    }

    @SerializedName("owner_id")
    private Long ownerId;

    @SerializedName("bot_id")
    private Long botId;

    @SerializedName("enable")
    private Boolean enable;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "api/bot/setBotPrivacyMode";
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
    public Serializable parseResponse(String responseBody) {
        Type fluentType = new TypeToken<RestResponse<Serializable>>() {
        }.getType();
        RestResponse<Serializable> apiResponse = gson.fromJson(responseBody, fluentType);
        if (null != apiResponse && null != apiResponse.getStatus() && apiResponse.getStatus()) {
            return apiResponse.getData();
        } else {
            log.error("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(BotClientEnum.FAIL.getCode(), BotClientEnum.FAIL.getDesc());
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
        if (null == botId) {
            this.botId = clientProfile.getBotId();
        }
        return super.buildBody(clientProfile);
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == ownerId || ownerId <= 0) {
            throw new BotArgumentException("ownerId must no be null");
        }
        if (null == botId || botId <= 0) {
            throw new BotArgumentException("botId must no be null");
        }
        if (enable == null) {
            throw new BotArgumentException("enable must no be null");
        }
        if (null == headers.get(HEADER_AUTHORIZATION) || headers.get(HEADER_AUTHORIZATION).isEmpty()) {
            throw new BotArgumentException("authorization of Fanbook Client must not be null");
        }
    }


    @Override
    protected String buildUrl(ClientProfile clientProfile) {
        String url = String.format("%s://%s/%s", clientProfile.getHttpProtocolType(), clientProfile.getDomain(), getEndpoint());
        if (url.contains(BOT_TOKEN_PLACE_HOLDER)) {
            url = url.replace(BOT_TOKEN_PLACE_HOLDER, clientProfile.getBotToken());
        }
        return url;
    }
}
