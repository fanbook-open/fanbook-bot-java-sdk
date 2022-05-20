package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Dice implements Serializable {
    private static final String VALUE_FIELD = "value";
    private static final String EMOJI_FIELD = "emoji";

    /**
     * Value of the dice,
     * 1-6 for “🎲”, “🎯” and “🎳” base emoji,
     * 1-5 for “🏀” and “⚽” base emoji,
     * 1-64 for “🎰” base emoji
     */
    @SerializedName(VALUE_FIELD)
    private Integer value;
    @SerializedName(EMOJI_FIELD)
    private String emoji; ///< Emoji on which the dice throw animation is based
}
