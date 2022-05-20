package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ChatPhoto implements Serializable {
    private static final String SMALLFILEID_FIELD = "small_file_id";
    private static final String SMALLFILEUNIQUEID_FIELD = "small_file_unique_id";
    private static final String BIGFILEID_FIELD = "big_file_id";
    private static final String BIGFILEUNIQUEID_FIELD = "big_file_unique_id";
    
    @SerializedName(SMALLFILEID_FIELD)
    private String smallFileId;

    @SerializedName(SMALLFILEUNIQUEID_FIELD)
    private String smallFileUniqueId;

    @SerializedName(BIGFILEID_FIELD)
    private String bigFileId;

    @SerializedName(BIGFILEUNIQUEID_FIELD)
    private String bigFileUniqueId;
}
