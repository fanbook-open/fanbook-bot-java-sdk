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
public class CallbackQuery implements Serializable {

    private static final String ID_FIELD = "id";
    private static final String FROM_FIELD = "from";
    private static final String MESSAGE_FIELD = "message";
    private static final String INLINE_MESSAGE_ID_FIELD = "inline_message_id";
    private static final String DATA_FIELD = "data";
    private static final String GAMESHORTNAME_FIELD = "game_short_name";
    private static final String CHAT_INSTANCE_FIELD = "chat_instance";

    @SerializedName(ID_FIELD)
    private String id; ///< Unique identifier for this query
    @SerializedName(FROM_FIELD)
    private User from; ///< Sender

    @SerializedName(MESSAGE_FIELD)
    private Message message;
    @SerializedName(INLINE_MESSAGE_ID_FIELD)
    private String inlineMessageId; ///< Optional. Identifier of the message sent via the bot in inline mode, that originated the query

    @SerializedName(DATA_FIELD)
    private String data;

    @SerializedName(GAMESHORTNAME_FIELD)
    private String gameShortName;

    @SerializedName(CHAT_INSTANCE_FIELD)
    private String chatInstance;
}
