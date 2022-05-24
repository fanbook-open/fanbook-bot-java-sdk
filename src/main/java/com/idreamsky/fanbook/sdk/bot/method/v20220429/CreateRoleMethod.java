package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.GuildRole;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.model.ApiResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * 创建服务器角色，返回GuildRole对象
 *
 * @author peng.gan
 */
@Data
@Slf4j
public class CreateRoleMethod extends BotMethod<GuildRole> {

    @SerializedName("guild_id")
    private String guildId;

    @SerializedName("name")
    private String name;

    @SerializedName("color")
    private Integer color;

    @SerializedName("position")
    private Long position;

    @SerializedName("mentionable")
    private Boolean mentionable;

    @SerializedName("hoist")
    private Boolean hoist;

    @Override
    protected String getEndpoint() {
        return "guild/role";
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.PUT;
    }

    @Override
    public GuildRole parseResponse(String responseBody) throws BotApiRequestException {
        Type fluentType = new TypeToken<ApiResponse<GuildRole>>() {
        }.getType();
        ApiResponse<GuildRole> apiResponse = gson.fromJson(responseBody, fluentType);
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
        if (null == guildId || guildId.isEmpty()) {
            throw new BotArgumentException("guildId must not be empty");
        }
        if (null == name || name.isEmpty()) {
            throw new BotArgumentException("name must not be empty");
        }
        if (null == color) {
            throw new BotArgumentException("color must not be null");
        }
        if (null == position) {
//            throw new BotArgumentException("position must not be null");
        }
    }
}
