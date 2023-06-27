package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class CirclePostContent implements Serializable {

    @SerializedName("post_id")
    private String postId;

    @SerializedName("guild_id")
    private String guildId;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("topic_name")
    private String topicName;

    @SerializedName("title")
    private String title;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("content")
    private String content;

    @SerializedName("topic_id")
    private String topicId;

    @SerializedName("content_v2")
    private String contentV2;

    @SerializedName("has_video")
    private Integer hasVideo;

    @SerializedName("post_type")
    private String postType;

    @SerializedName("cover")
    private CircleCover cover;

}
