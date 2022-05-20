package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class AppResponse implements Serializable {

    @SerializedName("app")
    private AppInfo app;

    @SerializedName("redirect_uri")
    private String redirectUri;

    @SerializedName("user")
    private UserInfo user;
}
