package com.idreamsky.fanbook.sdk.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * restful 风格的响应结果
 *
 * @author peng.gan
 */
@Data
public class RestResponse<T> implements Serializable {

    @SerializedName("status")
    private Boolean status;

    @SerializedName("data")
    public T data;

    @SerializedName("message")
    private String message;

}
