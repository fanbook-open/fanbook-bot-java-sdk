package com.idreamsky.fanbook.sdk.bot.model.v20230216;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 圈子基础信息
 *
 * @author peng.gan
 */
@Data
public class CircleBaseInfo implements Serializable {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("guild_id")
    private String guildId;

    @SerializedName("list_display")
    private Long listDisplay;

    @SerializedName("name")
    private String name;

    @SerializedName("overwrite")
    private List overwrite;

    @SerializedName("show_type")
    private Integer showType;

    @SerializedName("sort")
    private Integer sort;

    @SerializedName("top_define")
    private Object topDefine;

    @SerializedName("topic_id")
    private String topicId;

    @SerializedName("type")
    private Integer type;
}
