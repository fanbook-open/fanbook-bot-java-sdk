package com.idreamsky.fanbook.sdk.oauth2.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class InviteCodeResponse implements Serializable {

    @SerializedName("status")
    private Boolean status;

    @SerializedName("code")
    private Integer code;

    @SerializedName("message")
    private String message;

    @SerializedName("desc")
    private String desc;

    @SerializedName("request_id")
    private String requestId;

    @SerializedName("data")
    private Data data;

    @lombok.Data
    public static class Data implements Serializable{

        @SerializedName("user")
        private UserInfo user;

        @SerializedName("guild")
        private GuildInfo guild;

        @SerializedName("code")
        private Code code;
    }
}
