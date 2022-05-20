package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CirclePostReaction implements Serializable {

    @SerializedName("records")
    private List<CirclePostReactionRecord> records;

    @SerializedName("size")
    private Integer size;

    @SerializedName("list_id")
    private String listId;

    @SerializedName("next")
    private Boolean next;
}
