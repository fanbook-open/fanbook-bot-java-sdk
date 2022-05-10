package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Reaction implements Serializable {

    @SerializedName("reaction_to_message")
    private Message reactionToMessage;

    @SerializedName("action")
    private String action;

    @SerializedName("emoji")
    private String emoji;
}
