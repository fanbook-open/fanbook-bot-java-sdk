package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class PhotoSize implements Serializable {
    private static final String FILEID_FIELD = "file_id";
    private static final String FILEUNIQUEID_FIELD = "file_unique_id";
    private static final String WIDTH_FIELD = "width";
    private static final String HEIGHT_FIELD = "height";
    private static final String FILESIZE_FIELD = "file_size";
    private static final String FILEPATH_FIELD = "file_path";

    @SerializedName(FILEID_FIELD)
    private String fileId; ///< Identifier for this file, which can be used to download or reuse the file
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    @SerializedName(FILEUNIQUEID_FIELD)
    private String fileUniqueId;
    @SerializedName(WIDTH_FIELD)
    private Integer width; ///< Photo width
    @SerializedName(HEIGHT_FIELD)
    private Integer height; ///< Photo height
    @SerializedName(FILESIZE_FIELD)
    private Integer fileSize; ///< Optional. File size
    @SerializedName(FILEPATH_FIELD)
    private String filePath; ///< Undocumented field. Optional. Can contain the path to download the file directly without calling to getFile

}
