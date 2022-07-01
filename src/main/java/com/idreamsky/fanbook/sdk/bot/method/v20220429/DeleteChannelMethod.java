package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.model.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * 删除频道，适用于删除群
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteChannelMethod extends BotMethod<String> {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("guild_id")
    private String guildId;

    @Override
    protected String getEndpoint() {
        return "channel/delete";
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.POST;
    }

    @Override
    public String parseResponse(String responseBody) throws BotApiRequestException {
        Type fluentType = new TypeToken<ApiResponse<String>>() {
        }.getType();
        ApiResponse<String> apiResponse = gson.fromJson(responseBody, fluentType);
        if (null != apiResponse && null != apiResponse.getOk() && apiResponse.getOk()) {
            return apiResponse.getResult();
        } else if (null == apiResponse) {
            log.error("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(BotClientEnum.FAIL.getCode(), BotClientEnum.FAIL.getDesc());
        } else {
            log.error("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(apiResponse.getErrorCode(), apiResponse.getDescription());
        }
    }

    @Override
    public void validate() throws BotArgumentException {
        if (null == userId || userId.isEmpty()) {
            throw new BotArgumentException("userId must not be empty");
        }
        if (null == channelId || channelId.isEmpty()) {
            throw new BotArgumentException("channelId must not be empty");
        }
    }
}
