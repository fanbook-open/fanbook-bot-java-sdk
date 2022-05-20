package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class Animation implements Serializable {
    private static final String FILEID_FIELD = "file_id";
    private static final String FILEUNIQUEID_FIELD = "file_unique_id";
    private static final String WIDTH_FIELD = "width";
    private static final String HEIGHT_FIELD = "height";
    private static final String DURATION_FIELD = "duration";
    private static final String THUMB_FIELD = "thumb";
    private static final String FILENAME_FIELD = "file_name";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String FILESIZE_FIELD = "file_size";

    @SerializedName(FILEID_FIELD)
    @NonNull
    private String fileId; ///< Identifier for this file, which can be used to download or reuse the file
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    @SerializedName(FILEUNIQUEID_FIELD)
    @NonNull
    private String fileUniqueId;
    @SerializedName(WIDTH_FIELD)
    @NonNull
    private Integer width; ///< Video width as defined by sender
    @SerializedName(HEIGHT_FIELD)
    @NonNull
    private Integer height; ///< Video height as defined by sender
    @SerializedName(DURATION_FIELD)
    @NonNull
    private Integer duration; ///< Duration of the video in seconds as defined by sender
    @SerializedName(THUMB_FIELD)
    private PhotoSize thumb; ///< Optional. Animation thumbnail as defined by sender
    @SerializedName(FILENAME_FIELD)
    private String fileName; ///< Optional. Original animation filename as defined by sender
    @SerializedName(MIMETYPE_FIELD)
    private String mimetype; ///< Optional. MIME type of the file as defined by sender
    @SerializedName(FILESIZE_FIELD)
    private Integer fileSize; ///< Optional. File size
}
