package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.model.ApiResponse;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.ChannelInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * 获取服务器的频道列表，返回Channel数组
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListChannelMethod extends BotMethod<ArrayList<ChannelInfo>> {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("guild_id")
    private String guildId;

    @Override
    protected String getEndpoint() {
        return "channel/list";
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.POST;
    }

    @Override
    public ArrayList<ChannelInfo> parseResponse(String responseBody) throws BotApiRequestException {
        Type fluentType = new TypeToken<ApiResponse<ArrayList<ChannelInfo>>>() {
        }.getType();
        ApiResponse<ArrayList<ChannelInfo>> apiResponse = gson.fromJson(responseBody, fluentType);
        if (null != apiResponse && null != apiResponse.getOk() && apiResponse.getOk()) {
            return apiResponse.getResult();
        } else {
            log.info("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(BotClientEnum.FAIL.getCode(), BotClientEnum.FAIL.getDesc());
        }
    }

    @Override
    public void validate() throws BotArgumentException {
        if (null == userId || userId.isEmpty()) {
            throw new BotArgumentException("userId must not be empty");
        }
        if (null == guildId || guildId.isEmpty()) {
            throw new BotArgumentException("guildId must not be empty");
        }
    }
}
