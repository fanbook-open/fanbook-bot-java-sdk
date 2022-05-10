package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ChannelInfo implements Serializable {
    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("guild_id")
    private String guildId;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private Long type;

    @SerializedName("user_limit")
    private Long userLimit;

}
