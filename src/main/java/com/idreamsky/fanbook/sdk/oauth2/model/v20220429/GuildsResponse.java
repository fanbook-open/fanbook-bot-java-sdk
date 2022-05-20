package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GuildsResponse implements Serializable {

    @SerializedName("status")
    private Boolean status;

    @SerializedName("data")
    private List<GuildInfo> data;

    @SerializedName("message")
    private String message;

}
