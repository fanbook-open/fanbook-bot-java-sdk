package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Bot implements Serializable {

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("owner_id")
    private String ownerId;

    @SerializedName("username")
    private String username;

    @SerializedName("bot_name")
    private String botName;

    @SerializedName("bot_description")
    private String botDescription;

    @SerializedName("bot_about")
    private String botAbout;

    @SerializedName("bot_avatar")
    private String botAvatar;

    @SerializedName("commands")
    private List<BotCommand> commands;

    @SerializedName("bot_permissions")
    private Long botPermissions;

    @SerializedName("bot_class")
    private Long botClass;

    @SerializedName("bot_token")
    private String botToken;

    @SerializedName("webhook")
    private String webhook;

    @SerializedName("enable_inline_mode")
    private Boolean enableInlineMode;

    @SerializedName("enable_inline_geo")
    private Boolean enableInlineGeo;

    @SerializedName("join_group_allowed")
    private Boolean joinGroupAllowed;

    @SerializedName("enable_group_privacy_mode")
    private Boolean enableGroupPrivacyMode;

    @SerializedName("confirmed_update_id")
    private Long confirmedUpdateId;

    @SerializedName("market")
    private Boolean market;

    @SerializedName("guilds")
    private List<String> guilds;
}
