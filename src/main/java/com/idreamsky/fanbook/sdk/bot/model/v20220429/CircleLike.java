package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class CircleLike implements Serializable {
    @SerializedName("releated_id")
    private Long releatedId;

    @SerializedName("reaction_type")
    private String reactionType;
}
