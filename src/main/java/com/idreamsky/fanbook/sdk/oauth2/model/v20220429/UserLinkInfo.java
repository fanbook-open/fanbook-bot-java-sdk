package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserLinkInfo implements Serializable {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("area_code")
    private Integer areaCode;
}
