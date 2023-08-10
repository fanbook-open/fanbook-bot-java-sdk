package com.idreamsky.fanbook.sdk.bot.model.v20230216;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 问题表态
 */
@Data
public class QuestionReaction {

    @SerializedName("guild_id")
    private Long guildId;

    @SerializedName("channel_id")
    private Long channelId;

    @SerializedName("question_id")
    private Long questionId;

    @SerializedName("reaction")
    private String reaction;
}
