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
public class InlineKeyboardButton implements Serializable {

    private static final String TEXT_FIELD = "text";
    private static final String URL_FIELD = "url";
    private static final String CALLBACK_DATA_FIELD = "callback_data";
    private static final String CALLBACK_GAME_FIELD = "callback_game";
    private static final String SWITCH_INLINE_QUERY_FIELD = "switch_inline_query";
    private static final String SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD = "switch_inline_query_current_chat";
    private static final String PAY_FIELD = "pay";
    private static final String LOGIN_URL_FIELD = "login_url";
    private static final String WEBAPP_FIELD = "web_app";

    @SerializedName(TEXT_FIELD)
    @NonNull
    private String text; ///< Label text on the button
    /**
     * Optional.
     * HTTP or tg:// url to be opened when the button is pressed.
     * Links tg://user?id=<user_id> can be used to mention a user by their ID without using a username,
     * if this is allowed by their privacy settings.
     */
    @SerializedName(URL_FIELD)
    private String url;
    @SerializedName(CALLBACK_DATA_FIELD)
    private String callbackData; ///< Optional. Data to be sent in a callback query to the bot when button is pressed
    /**
     * Optional. Description of the game that will be launched when the user presses the button.
     *
     * @apiNote This type of button must always be the first button in the first row.
     */
    @SerializedName(CALLBACK_GAME_FIELD)
    private CallbackGame callbackGame;
    /**
     * Optional.
     * If set, pressing the button will prompt the user to select one of their chats,
     * open that chat and insert the bot‘s username and the specified inline query in the input field.
     * Can be empty, in which case just the bot’s username will be inserted.
     *
     * @apiNote This offers an easy way for users to start using your bot in inline mode when
     * they are currently in a private chat with it.
     * Especially useful when combined with switch_pm… actions – in this case the user will
     * be automatically returned to the chat they switched from, skipping the chat selection screen.
     */
    @SerializedName(SWITCH_INLINE_QUERY_FIELD)
    private String switchInlineQuery;
    /**
     * Optional. If set, pressing the button will insert the bot‘s username and the specified
     * inline query in the current chat's input field. Can be empty,
     * in which case only the bot’s username will be inserted.
     */
    @SerializedName(SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD)
    private String switchInlineQueryCurrentChat;

    /**
     * Optional. Specify True, to send a Buy button.
     *
     * @apiNote This type of button must always be the first button in the first row.
     */
    @SerializedName(PAY_FIELD)
    private Boolean pay;
    /**
     * Optional. An HTTP URL used to automatically authorize the user.
     * Can be used as a replacement for the Telegram Login Widget.
     */
    @SerializedName(LOGIN_URL_FIELD)
    private LoginUrl loginUrl;

    /**
     * Optional.
     * Description of the web app that will be launched when the user presses the button.
     * The web app will be able to send an arbitrary message on behalf of the user using the method answerWebAppQuery.
     * Available only in private chats between users and the bot.
     */
    @SerializedName(WEBAPP_FIELD)
    private WebAppInfo webApp;

}