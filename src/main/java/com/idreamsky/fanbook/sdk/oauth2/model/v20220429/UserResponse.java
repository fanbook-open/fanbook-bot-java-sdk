package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {

    @SerializedName("status")
    private Boolean status;

    @SerializedName("data")
    private UserInfo data;

    @SerializedName("message")
    private String message;

    @SerializedName("err")
    private String err;
}
