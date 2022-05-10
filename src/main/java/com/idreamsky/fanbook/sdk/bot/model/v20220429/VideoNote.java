package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class VideoNote implements Serializable {
    private static final String FILEID_FIELD = "file_id";
    private static final String FILEUNIQUEID_FIELD = "file_unique_id";
    private static final String LENGTH_FIELD = "length";
    private static final String DURATION_FIELD = "duration";
    private static final String THUMB_FIELD = "thumb";
    private static final String FILESIZE_FIELD = "file_size";

    @SerializedName(FILEID_FIELD)
    private String fileId; ///< Identifier for this file, which can be used to download or reuse the file
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    @SerializedName(FILEUNIQUEID_FIELD)
    private String fileUniqueId;
    @SerializedName(LENGTH_FIELD)
    private Integer length; ///< Video width and height as defined by sender
    @SerializedName(DURATION_FIELD)
    private Integer duration; ///< Duration of the video in seconds as defined by sender
    @SerializedName(THUMB_FIELD)
    private PhotoSize thumb; ///< Optional. Video thumbnail
    @SerializedName(FILESIZE_FIELD)
    private Integer fileSize; ///< Optional. File size
}
