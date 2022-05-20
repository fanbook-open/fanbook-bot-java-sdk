package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CirclePostSubInfo implements Serializable {

    @SerializedName("commentTotal")
    private Long commentTotal;

    @SerializedName("likeTotal")
    private Long likeTotal;

    @SerializedName("can_del")
    private Long canDel;

    @SerializedName("liked")
    private Long liked;

    @SerializedName("like_id")
    private List<String> likeId;

    @SerializedName("is_top")
    private Boolean isTop;

    @SerializedName("is_follow")
    private Boolean isFollow;
}
