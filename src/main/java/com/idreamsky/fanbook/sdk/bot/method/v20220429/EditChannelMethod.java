package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.bot.constant.v20220429.ChannelTypeEnum;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.PermissionOverwrite;
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

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author peng.gan
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditChannelMethod extends BotMethod<String> {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("guild_id")
    private String guildId;

    @SerializedName("name")
    private String name;

    /**
     * {@link ChannelTypeEnum}
     */
    @SerializedName("type")
    private Integer type;

    @SerializedName("topic")
    private String topic;

    @SerializedName("parent_id")
    private String parentId;

    @SerializedName("link")
    private String link;

    @SerializedName("icon")
    private String icon;

    @SerializedName("permission_overwrites")
    private List<PermissionOverwrite> permissionOverwrites;

    @Override
    protected String getEndpoint() {
        return "channel/edit";
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
            log.info("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(BotClientEnum.FAIL.getCode(), BotClientEnum.FAIL.getDesc());
        } else {
            log.info("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(apiResponse.getErrorCode(), apiResponse.getDescription());
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
        if (null == channelId || channelId.isEmpty()) {
            throw new BotArgumentException("channel_id must not be empty");
        }
    }
}
