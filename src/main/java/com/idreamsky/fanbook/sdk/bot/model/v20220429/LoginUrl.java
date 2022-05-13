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


    @SerializedName(URL_FIELD)
    @NonNull
    private String url;
    @SerializedName(FORWARD_TEXT_FIELD)
    private String forwardText; ///< Optional. New text of the button in forwarded messages.

    @SerializedName(BOT_USERNAME_FIELD)
    private String botUsername; ///< Optional. Animation duration
    @SerializedName(REQUEST_WRITE_ACCESS_FIELD)
    private Boolean requestWriteAccess; ///< Optional. Pass True to request the permission for your bot to send messages to the user.


}