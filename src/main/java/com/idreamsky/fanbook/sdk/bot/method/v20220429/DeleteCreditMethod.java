package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.model.ApiResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * 通过这个方法为服务台用户或者是群用户清除服务台荣誉数据，成功后返回 True
 *
 * @author peng.gan
 */
@Data
@Slf4j
public class DeleteCreditMethod extends BotMethod<Boolean> {
    @SerializedName("chat_id")
    private Long chatId;

    @SerializedName("guild_id")
    private String guildId;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("card_id")
    private String cardId;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "guild/credit";
    }

    /**
     * Fanbook bot api的接口的请求方式
     *
     * @return HttpMethodType
     */
    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.DELETE;
    }

    /**
     * 使用指定的泛型实体类T解析response body
     *
     * @param responseBody http response body
     * @return 反序列化类型T对应的实体类
     */
    @Override
    public Boolean parseResponse(String responseBody) {
        Type fluentType = new TypeToken<ApiResponse<Boolean>>() {
        }.getType();
        ApiResponse<Boolean> apiResponse = gson.fromJson(responseBody, fluentType);
        if (null != apiResponse && null != apiResponse.getOk() && apiResponse.getOk()) {
            return apiResponse.getOk();
        } else if (null == apiResponse) {
            log.info("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(BotClientEnum.FAIL.getCode(), BotClientEnum.FAIL.getDesc());
        } else {
            log.info("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(apiResponse.getErrorCode(), apiResponse.getDescription());
        }
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == userId) {
            throw new BotArgumentException("userId must not be null");
        }
        if (null == chatId && null == guildId) {
            throw new BotArgumentException("at least provide one between guildId and chatId");
        }
        if (null == cardId || cardId.isEmpty()) {
            throw new BotArgumentException("cardId must not be empty");
        }
    }
}
