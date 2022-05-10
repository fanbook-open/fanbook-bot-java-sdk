package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class AppInfo implements Serializable {

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("desc")
    private DescInfo desc;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    @SerializedName("name")
    private String name;

    @SerializedName("scopes")
    private String scopes;

    @Data
    public class DescInfo {
        @SerializedName("user.info")
        private String userInfo;

        @SerializedName("user.link")
        private String userLink;
    }
}
