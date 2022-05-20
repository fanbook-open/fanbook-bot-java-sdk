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

    @SerializedName(URL_FIELD)
    private String url;
    @SerializedName(CALLBACK_DATA_FIELD)
    private String callbackData; ///< Optional. Data to be sent in a callback query to the bot when button is pressed

    @SerializedName(CALLBACK_GAME_FIELD)
    private CallbackGame callbackGame;

    @SerializedName(SWITCH_INLINE_QUERY_FIELD)
    private String switchInlineQuery;

    @SerializedName(SWITCH_INLINE_QUERY_CURRENT_CHAT_FIELD)
    private String switchInlineQueryCurrentChat;


    @SerializedName(PAY_FIELD)
    private Boolean pay;

    @SerializedName(LOGIN_URL_FIELD)
    private LoginUrl loginUrl;


    @SerializedName(WEBAPP_FIELD)
    private WebAppInfo webApp;

}