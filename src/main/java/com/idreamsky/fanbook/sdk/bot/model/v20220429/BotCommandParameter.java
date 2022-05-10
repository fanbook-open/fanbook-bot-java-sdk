package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class BotCommandParameter implements Serializable {
    @SerializedName("key")
    private String key;

    @SerializedName("icon")
    private String icon;

    @SerializedName("k")
    private String k;

    @SerializedName("v")
    private String v;
}
