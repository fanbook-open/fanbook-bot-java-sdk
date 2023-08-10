package com.idreamsky.fanbook.sdk.bot.model.v20230216;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 发布的问题
 */
@Data
public class Question {

    @SerializedName("guild_id")
    private Long guildId;

    @SerializedName("channel_id")
    private Long channelId;

    @SerializedName("question_id")
    private Long questionId;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;
}
