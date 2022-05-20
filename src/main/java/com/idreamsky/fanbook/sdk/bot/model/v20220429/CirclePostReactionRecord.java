package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class CirclePostReactionRecord implements Serializable {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("username")
    private String username;

    @SerializedName("reaction_id")
    private String reactionId;
}
