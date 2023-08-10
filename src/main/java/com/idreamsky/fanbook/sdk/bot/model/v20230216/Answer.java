package com.idreamsky.fanbook.sdk.bot.model.v20230216;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 问题的回答
 */
@Data
public class Answer {

    @SerializedName("guild_id")
    private Long guildId;

    @SerializedName("channel_id")
    private Long channelId;

    @SerializedName("question_id")
    private Long questionId;

    @SerializedName("answer_id")
    private Long answerId;

    @SerializedName("content")
    private String content;
}
