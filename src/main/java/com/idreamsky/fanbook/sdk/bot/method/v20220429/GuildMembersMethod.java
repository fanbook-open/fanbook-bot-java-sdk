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

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 获取服务器的成员列表，分页获取的
 *
 * @author peng.gan
 */
@Data
@Slf4j
public class GuildMembersMethod extends BotMethod {


    @SerializedName("guild_id")
    private String guildId;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("ranges")
    private List<Range> ranges;

    @SerializedName("transaction")
    private String transaction;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "guild/members";
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
     * @param responseBody
     * @return
     */
    @Override
    public Serializable parseResponse(String responseBody) {
        Type fluentType = new TypeToken<ApiResponse<Serializable>>() {
        }.getType();
        ApiResponse<Serializable> apiResponse = gson.fromJson(responseBody, fluentType);
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
        if (null == guildId || guildId.isEmpty()) {
            throw new BotArgumentException("guildId must no be empty");
        }
        if (null == channelId || channelId.isEmpty()) {
            throw new BotArgumentException("channelId must no be empty");
        }
        if (null == userId || userId.isEmpty()) {
            throw new BotArgumentException("userId must no be empty");
        }
        if (null == ranges || ranges.isEmpty()) {
            throw new BotArgumentException("ranges must no be empty");
        }
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Range {

        @SerializedName("start")
        private Integer start;

        @SerializedName("end")
        private Integer end;
    }
}
