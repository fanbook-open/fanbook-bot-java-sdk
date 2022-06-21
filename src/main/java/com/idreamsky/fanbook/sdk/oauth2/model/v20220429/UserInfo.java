package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("username")
    private String username;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("token")
    private String token;

    @SerializedName("avatar_nft")
    private Boolean avatarNft;

}
