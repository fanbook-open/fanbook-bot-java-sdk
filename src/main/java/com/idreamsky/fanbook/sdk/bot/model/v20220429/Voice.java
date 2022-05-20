package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Voice implements Serializable {
    private static final String FILEID_FIELD = "file_id";
    private static final String FILEUNIQUEID_FIELD = "file_unique_id";
    private static final String DURATION_FIELD = "duration";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String FILESIZE_FIELD = "file_size";

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
}
