package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.commons.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.Bot;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.model.RestResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.ArrayList;

@Data
@Slf4j
public class GetBotsMethod extends BotMethod<ArrayList<Bot>> {

    /**
     * 注意，这里传递的是Fanbook 客户端使用的用户token
     *
     * @param authorizationOfFanbookClient
     */
    public void setAuthorization(String authorizationOfFanbookClient) {
        super.addHeader(HEADER_AUTHORIZATION, authorizationOfFanbookClient);
    }

    @SerializedName("owner_id")
    private Long ownerId;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "api/bot/getBots";
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
    public ArrayList<Bot> parseResponse(String responseBody) {
        Type fluentType = new TypeToken<RestResponse<ArrayList<Bot>>>() {
        }.getType();
        RestResponse<ArrayList<Bot>> apiResponse = gson.fromJson(responseBody, fluentType);
        if (null != apiResponse && null != apiResponse.getStatus() && apiResponse.getStatus()) {
            return apiResponse.getData();
        } else {
            log.info("Fanbook bot api 接口响应非成功数据,body:{}", responseBody);
            throw new BotApiRequestException(BotClientEnum.FAIL.getCode(), BotClientEnum.FAIL.getDesc());
        }
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == ownerId || ownerId <= 0) {
            throw new BotArgumentException("ownerId must no be null");
        }
        if (null == headers.get(HEADER_AUTHORIZATION) || headers.get(HEADER_AUTHORIZATION).isEmpty()) {
            throw new BotArgumentException("authorization of Fanbook Client must not be null");
        }
    }
}
