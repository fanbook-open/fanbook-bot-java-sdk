package com.idreamsky.fanbook.sdk.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * Fanbook bot api response
 *
 * @author peng.gan
 */
@Data
public class ApiResponse<T> implements Serializable {
    @SerializedName("ok")
    private Boolean ok;
    @SerializedName("err_code")
    private Integer errorCode;
    @SerializedName("description")
    private String description;
    @SerializedName("result")
    private T result;
}
