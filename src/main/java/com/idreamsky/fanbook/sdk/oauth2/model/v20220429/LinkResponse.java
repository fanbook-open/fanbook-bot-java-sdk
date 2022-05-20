package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class LinkResponse implements Serializable {
    @SerializedName("status")
    private Boolean status;

    @SerializedName("data")
    private UserLinkInfo data;
}
