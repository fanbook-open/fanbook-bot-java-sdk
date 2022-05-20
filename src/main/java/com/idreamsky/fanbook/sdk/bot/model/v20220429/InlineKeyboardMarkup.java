package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InlineKeyboardMarkup implements Serializable {

    private static final String KEYBOARD_FIELD = "inline_keyboard";

    @SerializedName(KEYBOARD_FIELD)
    @NonNull
    @Singular(value = "keyboardRow")
    private List<List<InlineKeyboardButton>> keyboard; ///< Array of button rows, each represented by an Array of Strings

}