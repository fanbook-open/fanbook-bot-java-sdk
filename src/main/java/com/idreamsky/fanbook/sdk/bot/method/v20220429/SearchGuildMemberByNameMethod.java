package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.ChatMember;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 通过这个方法可按照用户 username 搜索服务台用户，成功后返回 ChatMember 数组
 * <p>注意username参数有大小限制，目前暂定是100个</p>
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchGuildMemberByNameMethod extends BotMethod<ArrayList<ChatMember>> {

    @SerializedName("guild_id")
    private Long guildId;

    @SerializedName("username")
    private List<String> username;

    @Override
    protected String getEndpoint() {
        return "searchGuildMemberByName";
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.POST;
    }

    @Override
    public ArrayList<ChatMember> parseResponse(String responseBody) throws BotApiRequestException {
        Type fluentType = new TypeToken<ApiResponse<ArrayList<ChatMember>>>() {
        }.getType();
        ApiResponse<ArrayList<ChatMember>> apiResponse = gson.fromJson(responseBody, fluentType);
        if (null == apiResponse) {
            log.error("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(BotClientEnum.FAIL.getCode(), BotClientEnum.FAIL.getDesc());
        } else if (null != apiResponse.getOk() && apiResponse.getOk()) {
            return apiResponse.getResult();
        } else {
            log.error("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(apiResponse.getErrorCode(), apiResponse.getDescription());
        }
    }

    @Override
    public void validate() throws BotArgumentException {
        if (null == guildId) {
            throw new BotArgumentException("guildId must not be null");
        }
        if (null == username || username.size() <= 0) {
            throw new BotArgumentException("username must not be empty");
        }
    }
}
