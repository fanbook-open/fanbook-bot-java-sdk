package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class SendCodeResponse implements Serializable {

    @SerializedName("status")
    private Boolean status;

    @SerializedName("data")
    private String data;
}
