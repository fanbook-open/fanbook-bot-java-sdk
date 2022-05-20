package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Audio implements Serializable {
    private static final String FILEID_FIELD = "file_id";
    private static final String FILEUNIQUEID_FIELD = "file_unique_id";
    private static final String DURATION_FIELD = "duration";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String FILESIZE_FIELD = "file_size";
    private static final String TITLE_FIELD = "title";
    private static final String PERFORMER_FIELD = "performer";
    private static final String THUMB_FIELD = "thumb";
    private static final String FILENAME_FIELD = "file_name";

    @SerializedName(FILEID_FIELD)
    private String fileId; ///< Identifier for this file, which can be used to download or reuse the file
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    @SerializedName(FILEUNIQUEID_FIELD)
    private String fileUniqueId;
    @SerializedName(DURATION_FIELD)
    private Integer duration; ///< Integer	Duration of the audio in seconds as defined by sender
    @SerializedName(MIMETYPE_FIELD)
    private String mimeType; ///< Optional. MIME type of the file as defined by sender
    @SerializedName(FILESIZE_FIELD)
    private Integer fileSize; ///< Optional. File size
    @SerializedName(TITLE_FIELD)
    private String title; ///< Optional. Title of the audio as defined by sender or by audio tags
    @SerializedName(PERFORMER_FIELD)
    private String performer; ///< Optional. Performer of the audio as defined by sender or by audio tags
    @SerializedName(THUMB_FIELD)
    private PhotoSize thumb; ///< Optional. Thumbnail of the album cover to which the music file belongs
    @SerializedName(FILENAME_FIELD)
    private String fileName; ///< Optional. Original filename as defined by sender

}
