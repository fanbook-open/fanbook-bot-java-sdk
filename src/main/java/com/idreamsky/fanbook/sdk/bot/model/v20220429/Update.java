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
    private InlineQuery inlineQuery;

    @SerializedName("chosen_inline_result")
    private ChosenInlineQuery chosenInlineResult;

    @SerializedName("callback_query")
    private CallbackQuery callbackQuery;

    @SerializedName("shipping_query")
    private ShippingQuery shippingQuery;

    @SerializedName("pre_checkout_query")
    private PreCheckoutQuery preCheckoutQuery;

    @SerializedName("poll")
    private Poll poll;

    @SerializedName("poll_answer")
    private PollAnswer pollAnswer;
}
