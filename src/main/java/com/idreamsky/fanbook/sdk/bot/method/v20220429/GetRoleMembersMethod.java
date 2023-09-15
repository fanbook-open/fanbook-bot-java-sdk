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

/**
 * 通过这个方法可获取服务台的角色列表，成功后返回 ChatMember 数组
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetRoleMembersMethod extends BotMethod<ArrayList<ChatMember>> {
    @SerializedName("guild_id")
    private Long guildId;

    @SerializedName("role_id")
    private Long roleId;

    @SerializedName("last_id")
    private Long lastId;

    @SerializedName("size")
    private Long size;
    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "getRoleMembers";
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
     * @param responseBody http response body
     * @return 反序列化类型T对应的实体类
     */
    @Override
    public ArrayList<ChatMember> parseResponse(String responseBody) {
        Type fluentType = new TypeToken<ApiResponse<ArrayList<ChatMember>>>() {
        }.getType();
        ApiResponse<ArrayList<ChatMember>> apiResponse = gson.fromJson(responseBody, fluentType);
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

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == guildId) {
            throw new BotArgumentException("guildId must not be null");
        }
        if (null == roleId) {
            throw new BotArgumentException("roleId must not be null");
        }
    }
}
