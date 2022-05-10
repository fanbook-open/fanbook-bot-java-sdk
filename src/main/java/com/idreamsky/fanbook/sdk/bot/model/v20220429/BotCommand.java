package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BotCommand implements Serializable {

    @SerializedName("command")
    private String command;

    @SerializedName("description")
    private String description;

    @SerializedName("visible_level")
    private Integer visibleLevel;

    @SerializedName("select_parameters")
    private List<List<BotCommandParameter>> selectParameters;

    @SerializedName("form_parameters")
    private List<List<BotCommandParameter>> formParameters;

    @SerializedName("hide")
    private boolean hide;

    @SerializedName("clickable")
    private boolean clickable;

    @SerializedName("app_id")
    private String appId;

    @SerializedName("")
    private String url;
}
