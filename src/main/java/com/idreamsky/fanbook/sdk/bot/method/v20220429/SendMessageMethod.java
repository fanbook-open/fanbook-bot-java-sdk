package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.BotClientEnum;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.InlineKeyboardMarkup;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.Message;
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
import java.util.List;
import java.util.Map;

/**
 * 接口使用该消息可以发送一些文本消息，包括富文本和动态卡片. 成功后返回 Message 对象.
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendMessageMethod extends BotMethod<Message> {

    @SerializedName("chat_id")
    private Long chatId;

    @SerializedName("text")
    private String text;

    @SerializedName("parse_mode")
    private String parseMode;

    @SerializedName("selective")
    private Boolean selective;

    @SerializedName("disable_web_page_preview")
    private Boolean disableWebPagePreview;

    @SerializedName("disable_notification")
    private Boolean disableNotification;

    @SerializedName("reply_to_message_id")
    private Long replyToMessageId;

    @SerializedName("replyToMessageIdLevel2")
    private Long reply_to_message_id_level_2;

    @SerializedName("reply_markup")
    private InlineKeyboardMarkup replyMarkup;

    @SerializedName("unreactive")
    private Long unreactive;

    @SerializedName("desc")
    private String desc;

    @SerializedName("ephemeral")
    private Boolean ephemeral;

    @SerializedName("users")
    private List<String> users;


    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "sendMessage";
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

    @Override
    public Message parseResponse(String responseBody) {
        Type fluentType = new TypeToken<ApiResponse<Message>>() {
        }.getType();
        ApiResponse<Message> apiResponse = gson.fromJson(responseBody, fluentType);
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
        if (null == chatId) {
            throw new BotArgumentException("chat id must no be null");
        }
        if (null == text || text.isEmpty()) {
            throw new BotArgumentException("text must no be empty");
        }
    }
}
