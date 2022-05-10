package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.commons.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.model.ApiResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

@Data
@Slf4j
public class KickChatMemberMethod extends BotMethod<Boolean> {

    @SerializedName("chat_id")
    private Long chatId;

    @SerializedName("guild_id")
    private Long guildId;

    @SerializedName("user_id")
    private Long userId;

    @SerializedName("until_date")
    private Long untilDate;


    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "kickChatMember";
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

    @Override
    public Boolean parseResponse(String responseBody) {
        Type fluentType = new TypeToken<ApiResponse<Boolean>>() {
        }.getType();
        ApiResponse<Boolean> apiResponse = gson.fromJson(responseBody, fluentType);
        if (null != apiResponse && null != apiResponse.getOk() && apiResponse.getOk()) {
            return apiResponse.getResult();
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
     * @throws BotArgumentException
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == userId) {
            throw new BotArgumentException("user_id must no be null");
        }
        if (null == chatId && null == guildId) {
            throw new BotArgumentException("At least one chat_id and guild_id is passed");
        }
    }
}
