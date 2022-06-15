package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class GuildRole implements Serializable {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("position")
    private Long position;

    @SerializedName("permissions")
    private Long permissions;

    @SerializedName("color")
    private Integer color;

    @SerializedName("mentionable")
    private Boolean mentionable;

    @SerializedName("member_count")
    private Long memberCount;

    @SerializedName("managed")
    private Boolean managed;

    @SerializedName("tag")
    private Tag tag;

    @Data
    public static class Tag implements Serializable {

        @SerializedName("bot_id")
        private String botId;
    }
}
