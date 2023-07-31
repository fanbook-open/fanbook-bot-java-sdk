package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GuildCredit implements Serializable {

    @SerializedName("authority")
    private CreditAuthority authority;

    @SerializedName("title")
    private CreditTitle title;

    @SerializedName("slots")
    private List<List<CreditSlot>> slots;

    @SerializedName("type")
    private Integer type;
}
