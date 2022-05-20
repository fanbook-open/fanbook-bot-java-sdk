package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class MessageEntity implements Serializable {

    private static final String TYPE_FIELD = "type";
    private static final String OFFSET_FIELD = "offset";
    private static final String LENGTH_FIELD = "length";
    private static final String URL_FIELD = "url";
    private static final String USER_FIELD = "user";
    private static final String LANGUAGE_FIELD = "language";
    /**
     * Type of the entity.
     * Currently, can be:
     * - “mention” (@username)
     * - “hashtag” (#hashtag)
     * - “cashtag” ($USD)
     * - “bot_command” (/start@jobs_bot)
     * - “url” (https://telegram.org)
     * - “email” (do-not-reply@telegram.org)
     * - “phone_number” (+1-212-555-0123),
     * - “bold” (bold text)
     * - “italic” (italic text)
     * - “underline” (underlined text)
     * - “strikethrough” (strikethrough text)
     * - “spoiler” (spoiler message)
     * - “code” (monowidth string)
     * - “pre” (monowidth block)
     * - “text_link” (for clickable text URLs)
     * - “text_mention” (for users without usernames)
     */
    @SerializedName(TYPE_FIELD)
    @NonNull
    private String type;
    @SerializedName(OFFSET_FIELD)
    @NonNull
    private Integer offset; ///< Offset in UTF-16 code units to the start of the entity
    @SerializedName(LENGTH_FIELD)
    @NonNull
    private Integer length; ///< Length of the entity in UTF-16 code units
    @SerializedName(URL_FIELD)
    private String url; ///< Optional. For “text_link” only, url that will be opened after user taps on the text
    @SerializedName(USER_FIELD)
    private User user; ///< Optional. For “text_mention” only, the mentioned user
    @SerializedName(LANGUAGE_FIELD)
    private String language; ///< Optional. For “pre” only, the programming language of the entity text
    @Expose(serialize = false, deserialize = false)
    private String text; ///< Text present in the entity. Computed from offset and length

    protected void computeText(String message) {
        if (message != null) {
            text = message.substring(offset, offset + length);
        }
    }
}
