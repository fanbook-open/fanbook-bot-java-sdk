package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PollAnswer implements Serializable {

    @SerializedName("poll_id")
    private String pollId;

    @SerializedName("user")
    private User user;

    @SerializedName("option_ids")
    private List<Long> optionIds;
}
