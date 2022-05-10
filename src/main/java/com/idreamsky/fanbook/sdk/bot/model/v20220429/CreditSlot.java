package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditSlot implements Serializable {

    @SerializedName("label")
    private String label;

    @SerializedName("img")
    private String img;

    /**
     * 必要字段
     */
    @SerializedName("value")
    private String value;
}
