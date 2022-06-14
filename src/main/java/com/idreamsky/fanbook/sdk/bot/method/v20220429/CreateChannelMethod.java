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
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 创建频道
 *
 * @author peng.gan
 */
@Data
@Slf4j
public class CreateChannelMethod extends BotMethod<ChannelInfo> {

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

    @SerializedName("permission_overwrites")
    private List<PermissionOverwrite> permissionOverwrites;

    @Override
    protected String getEndpoint() {
        return "channel/create";
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.POST;
    }

    @Override
    public ChannelInfo parseResponse(String responseBody) throws BotApiRequestException {
        Type fluentType = new TypeToken<ApiResponse<ChannelInfo>>() {
        }.getType();
        ApiResponse<ChannelInfo> apiResponse = gson.fromJson(responseBody, fluentType);
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
        if (null == name || name.isEmpty()) {
            throw new BotArgumentException("name must not be empty");
        }
        if (null == type) {
            throw new BotArgumentException("type || must not be null");
        }
    }
}
