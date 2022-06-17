package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Code implements Serializable {
    @SerializedName("status")
    private Integer status;

    @SerializedName("channel_on_del")
    private Integer channelOnDel;

    @SerializedName("channel_type")
    private Integer channelType;
}
