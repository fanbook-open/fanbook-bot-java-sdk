package com.idreamsky.fanbook.sdk.bot.method.v20230731;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.bot.model.v20230216.CircleBaseInfo;
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
 * 圈子基本数据信息
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CircleInfoMethod extends BotMethod<ArrayList<CircleBaseInfo>> {

    @SerializedName("guild_id")
    private Long guildId;

    @Override
    protected String getEndpoint() {
        return "v2/circle/info";
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return HttpMethodType.POST;
    }

    @Override
    public ArrayList<CircleBaseInfo> parseResponse(String responseBody) throws BotApiRequestException {
        Type fluentType = new TypeToken<ApiResponse<ArrayList<CircleBaseInfo>>>() {
        }.getType();
        ApiResponse<ArrayList<CircleBaseInfo>> apiResponse = gson.fromJson(responseBody, fluentType);
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
        if (null == guildId || guildId <= 0) {
            throw new BotArgumentException("guildId must not be null and must bigger than zero");
        }
    }
}
