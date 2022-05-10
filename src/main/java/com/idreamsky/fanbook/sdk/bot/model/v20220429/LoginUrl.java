package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class LoginUrl implements Serializable {
    private static final String URL_FIELD = "url";
    private static final String FORWARD_TEXT_FIELD = "forward_text";
    private static final String BOT_USERNAME_FIELD = "bot_username";
    private static final String REQUEST_WRITE_ACCESS_FIELD = "request_write_access";

    /**
     * An HTTP URL to be opened with user authorization data added to the query string when the button is pressed.
     * If the user refuses to provide authorization data, the original URL without information about the user will be opened.
     * The data added is the same as described in Receiving authorization data.
     *
     * @implNote You must always check the hash of the received data to verify the authentication and the integrity
     * of the data as described in Checking authorization.
     */
    @SerializedName(URL_FIELD)
    @NonNull
    private String url;
    @SerializedName(FORWARD_TEXT_FIELD)
    private String forwardText; ///< Optional. New text of the button in forwarded messages.
    /**
     * Optional. Username of a bot, which will be used for user authorization. See Setting up a bot for more details.
     * If not specified, the current bot's username will be assumed.
     * The url's domain must be the same as the domain linked with the bot.
     */
    @SerializedName(BOT_USERNAME_FIELD)
    private String botUsername; ///< Optional. Animation duration
    @SerializedName(REQUEST_WRITE_ACCESS_FIELD)
    private Boolean requestWriteAccess; ///< Optional. Pass True to request the permission for your bot to send messages to the user.


}