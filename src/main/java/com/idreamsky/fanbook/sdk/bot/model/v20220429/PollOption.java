

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
public class PollOption implements Serializable {
    private static final String TEXT_FIELD = "text";
    private static final String VOTERCOUNT_FIELD = "voter_count";

    @SerializedName(TEXT_FIELD)
    private String text; ///< Option text, 1-100 characters
    @SerializedName(VOTERCOUNT_FIELD)
    private Integer voterCount; ///< Number of users that voted for this option
}
