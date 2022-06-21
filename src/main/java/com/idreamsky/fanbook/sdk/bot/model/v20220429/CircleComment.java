package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class CircleComment implements Serializable {
    @SerializedName("post_id")
    private Long postId;

    @SerializedName("comment_id")
    private Long commentId;

    @SerializedName("content")
    private String content;
}
