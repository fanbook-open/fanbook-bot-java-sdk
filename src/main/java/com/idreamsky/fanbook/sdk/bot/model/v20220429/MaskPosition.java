package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class MaskPosition implements Serializable {
    private static final String POINT_FIELD = "point";
    private static final String XSHIFT_FIELD = "x_shift";
    private static final String YSHIFT_FIELD = "y_shift";
    private static final String SCALE_FIELD = "scale";

    @SerializedName(POINT_FIELD)
    @NonNull
    private String point; ///< The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
    @SerializedName(XSHIFT_FIELD)
    @NonNull
    private Float xShift; ///< Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
    @SerializedName(YSHIFT_FIELD)
    @NonNull
    private Float yShift; ///< Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
    @SerializedName(SCALE_FIELD)
    @NonNull
    private Float scale; ///< Mask scaling coefficient. For example, 2.0 means double size.


}
