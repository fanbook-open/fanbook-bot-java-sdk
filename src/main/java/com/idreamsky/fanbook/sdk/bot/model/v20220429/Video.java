package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * This object represents a video file.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Video implements Serializable {

    private static final String FILEID_FIELD = "file_id";
    private static final String FILEUNIQUEID_FIELD = "file_unique_id";
    private static final String WIDTH_FIELD = "width";
    private static final String HEIGHT_FIELD = "height";
    private static final String DURATION_FIELD = "duration";
    private static final String THUMB_FIELD = "thumb";
    private static final String MIMETYPE_FIELD = "mime_type";
    private static final String FILESIZE_FIELD = "file_size";
    private static final String FILENAME_FIELD = "file_name";

    @SerializedName(FILEID_FIELD)
    private String fileId; ///< Identifier for this file, which can be used to download or reuse the file

    @SerializedName(FILEUNIQUEID_FIELD)
    private String fileUniqueId;
    @SerializedName(WIDTH_FIELD)
    private Integer width; ///< Video width as defined by sender
    @SerializedName(HEIGHT_FIELD)
    private Integer height; ///< Video height as defined by sender
    @SerializedName(DURATION_FIELD)
    private Integer duration; ///< Duration of the video in seconds as defined by sender
    @SerializedName(THUMB_FIELD)
    private PhotoSize thumb; ///< Video thumbnail
    @SerializedName(MIMETYPE_FIELD)
    private String mimeType; ///< Optional. Mime type of a file as defined by sender
    @SerializedName(FILESIZE_FIELD)
    private Integer fileSize; ///< Optional. File size
    @SerializedName(FILENAME_FIELD)
    private String fileName; ///< Optional. Original filename as defined by sender
}
