package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.Update;
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
 * <p>
 * 使用这个接口接收服务器里所有的Update，这是一个长轮询的设计方案，
 * 返回一组Update对象，默认情况下只能收到公开频道的NewJoin消息和艾特机器人的消息，
 * 如果想接收所有类型的消息，必须调用SetBotPrivacyMode接口去打开Privacy模式，此时才能接收所有类型的消息，
 * 比如圈子，表态，pin，图片，视频等等消息。
 * </p>
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUpdatesMethod extends BotMethod<ArrayList<Update>> {

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("limit")
    private Integer limit;

    @SerializedName("timeout")
    private Integer timeout = 3;

    @SerializedName("allowed_updates")
    private List<String> allowedUpdates;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "getUpdates";
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
    public ArrayList<Update> parseResponse(String responseBody) throws BotApiRequestException {
        Type fluentType = new TypeToken<ApiResponse<ArrayList<Update>>>() {
        }.getType();
        ApiResponse<ArrayList<Update>> apiResponse = gson.fromJson(responseBody, fluentType);
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
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {

    }
}
