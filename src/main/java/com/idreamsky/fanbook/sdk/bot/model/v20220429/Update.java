package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Update implements Serializable {

    @SerializedName("update_id")
    private Long updateId;

    @SerializedName("message")
    private Message message;

    @SerializedName("edited_message")
    private Message editedMessage;

    @SerializedName("channel_post")
    private Message channelPost;

    @SerializedName("edited_channel_post")
    private Message editedChannelPost;

    @SerializedName("inline_query")
    private Object inlineQuery;

    @SerializedName("chosen_inline_result")
    private Object chosenInlineResult;

    @SerializedName("callback_query")
    private Object callbackQuery;

    @SerializedName("shipping_query")
    private Object shippingQuery;

    @SerializedName("pre_checkout_query")
    private Object preCheckoutQuery;

    @SerializedName("poll")
    private Object poll;

    @SerializedName("poll_answer")
    private Object pollAnswer;
}
