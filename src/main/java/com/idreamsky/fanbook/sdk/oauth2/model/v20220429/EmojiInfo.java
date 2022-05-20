package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmojiInfo implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("w")
    private Long w;

    @SerializedName("h")
    private Long h;
}
