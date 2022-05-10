package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.google.gson.annotations.SerializedName;
import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 获取圈子动态的评论列表，支持分页拉取
 *
 * @author peng.gan
 */
@Data
@Slf4j
// FIXME 接口没调通
public class CirclePostCommentListMethod extends BotMethod {

    @SerializedName("post_id")
    private String postId;

    @SerializedName("list_id")
    private String listId;

    @SerializedName("size")
    private String size;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("since_id")
    private String sinceId;

    /**
     * 获取接口的端点
     *
     * @return string
     */
    @Override
    protected String getEndpoint() {
        return "circle/commentList";
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
    public Serializable parseResponse(String responseBody) throws BotApiRequestException {
        return responseBody;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException
     */
    @Override
    public void validate() throws BotArgumentException {
    }
}
