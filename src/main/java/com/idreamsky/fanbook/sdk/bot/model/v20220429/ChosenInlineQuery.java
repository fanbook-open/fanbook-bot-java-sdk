package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * Represents a result of an inline query that was chosen by the user and sent to their chat
 * partner.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChosenInlineQuery implements Serializable {
    private static final String RESULTID_FIELD = "result_id";
    private static final String FROM_FIELD = "from";
    private static final String LOCATION_FIELD = "location";
    private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
    private static final String QUERY_FIELD = "query";

    @SerializedName(RESULTID_FIELD)
    @NonNull
    private String resultId; ///< The unique identifier for the result that was chosen.
    @SerializedName(FROM_FIELD)
    @NonNull
    private User from; ///< The user that chose the result.
    @SerializedName(LOCATION_FIELD)
    private Location location; ///< Optional. Sender location, only for bots that require user location
    /**
     * Optional.
     * Identifier of the sent inline message.
     * Available only if there is an inline keyboard attached to the message.
     * Will be also received in callback queries and can be used to edit the message.
     */
    @SerializedName(INLINE_MESSAGE_ID_FIELD)
    private String inlineMessageId;
    @SerializedName(QUERY_FIELD)
    @NonNull
    private String query; ///< The query that was used to obtain the result.
}
