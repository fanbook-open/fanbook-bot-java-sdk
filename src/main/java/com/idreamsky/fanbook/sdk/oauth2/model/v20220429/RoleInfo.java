package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleInfo implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("permissions")
    private Long permissions;

    @SerializedName("hoist")
    private Boolean hoist;

    @SerializedName("color")
    private Long color;

    @SerializedName("position")
    private Long position;
}
