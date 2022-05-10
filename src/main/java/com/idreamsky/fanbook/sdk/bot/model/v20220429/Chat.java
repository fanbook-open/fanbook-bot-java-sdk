package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Chat implements Serializable {

    @SerializedName("id")
    private Long id;

    @SerializedName("type")
    private String type;

    @SerializedName("guild_id")
    private Long guildId;

    @SerializedName("title")
    private String title;

    @SerializedName("username")
    private String username;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("photo")
    private ChatPhoto photo;

    @SerializedName("description")
    private String description;

    @SerializedName("invite_link")
    private String inviteLink;

    @SerializedName("pinned_message")
    private Message pinnedMessage;
}
