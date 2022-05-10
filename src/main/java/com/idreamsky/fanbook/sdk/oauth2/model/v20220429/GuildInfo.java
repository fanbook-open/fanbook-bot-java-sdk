package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GuildInfo implements Serializable {

    @SerializedName("guildId")
    private String guild_id;

    @SerializedName("name")
    private String name;

    @SerializedName("icon")
    private String icon;

    @SerializedName("banner")
    private String banner;

    @SerializedName("description")
    private String description;

    @SerializedName("owner_id")
    private String ownerId;

    @SerializedName("system_channel_id")
    private String systemChannelId;

    @SerializedName("userRoles")
    private List<String> userRoles;

    @SerializedName("channels")
    private List<ChannelInfo> channels;

    @SerializedName("roles")
    private List<RoleInfo> roles;

    @SerializedName("emojis")
    private List<EmojiInfo> emojis;

    @SerializedName("permissions")
    private Long permissions;

    @SerializedName("user_pending")
    private Boolean userPending;

    @SerializedName("notification_channel_id")
    private String notificationChannelId;
}
