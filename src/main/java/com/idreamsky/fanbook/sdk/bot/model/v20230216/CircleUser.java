package com.idreamsky.fanbook.sdk.bot.model.v20230216;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * 圈子用户信息
 */
@Data
public class CircleUser implements Serializable {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("is_bot")
    private Boolean isBot;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("username")
    private String username;

    @SerializedName("avatar")
    private String avatar;
}
