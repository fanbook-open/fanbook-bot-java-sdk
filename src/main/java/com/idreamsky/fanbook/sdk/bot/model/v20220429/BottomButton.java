package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author haojia.guo
 * @create 2022年08月12日 17:14
 * @desc
 */
@Data
@Builder
public class BottomButton implements Serializable {
    @SerializedName("content")
    private String content;
    @SerializedName("url")
    private String url;
}
