package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Data
public class Game implements Serializable {
    private static final String TITLE_FIELD = "title";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String PHOTO_FIELD = "photo";
    private static final String ANIMATION_FIELD = "animation";
    private static final String TEXT_FIELD = "text";
    private static final String TEXTENTITIES_FIELD = "text_entities";

    @SerializedName(TITLE_FIELD)
    @NonNull
    private String title; ///< Title of the game
    @SerializedName(DESCRIPTION_FIELD)
    @NonNull
    private String description; ///< Description of the game
    @SerializedName(PHOTO_FIELD)
    @NonNull
    private List<PhotoSize> photo; ///< Photo
    /**
     * Optional. Brief description of the game or high scores included in the game message.
     * Can be automatically edited to include current high scores for the game
     * when the bot calls setGameScore, or manually edited using editMessageText.
     * 0-4096 characters.
     */
    @SerializedName(TEXT_FIELD)
    private String text;
    /**
     * Optional. Special entities that appear in text, such as usernames,
     * URLs, bot commands, etc.
     */
    @SerializedName(TEXTENTITIES_FIELD)
    private List<MessageEntity> entities;
    @SerializedName(ANIMATION_FIELD)
    private Animation animation; ///< Optional. Animation

    public boolean hasEntities() {
        return entities != null && !entities.isEmpty();
    }
}
