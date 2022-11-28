package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
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

import java.io.Serializable;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageCardAutoMethod extends BotMethod {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("message_id")
    private String messageId;

    @SerializedName("max")
    private Integer max;

    @SerializedName("user_id")
    private String userId;


    @Override
    protected String getEndpoint() {
        return "interaction/message_card/auto";
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.POST;
    }

    @Override
    public Serializable parseResponse(String responseBody) throws BotApiRequestException {
        ApiResponse<Serializable> apiResponse = gson.fromJson(responseBody, ApiResponse.class);
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
        if (null == channelId || channelId.isEmpty()) {
            throw new BotArgumentException("channelId must not be empty");
        }
        if (null == messageId || messageId.isEmpty()) {
            throw new BotArgumentException("messageId must not be empty");
        }
        if (null == max) {
            throw new BotArgumentException("max must not be null");
        }
    }
}
