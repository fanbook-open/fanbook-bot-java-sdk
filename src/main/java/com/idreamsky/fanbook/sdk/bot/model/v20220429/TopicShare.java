package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TopicShare implements Serializable {

    @SerializedName("user_id")
    private Long userId;

    @SerializedName("channel_id")
    private Long channelId;

    @SerializedName("message_id")
    private Long messageId;
}
