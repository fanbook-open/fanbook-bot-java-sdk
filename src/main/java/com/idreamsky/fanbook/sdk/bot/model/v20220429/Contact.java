package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Contact implements Serializable {
    private static final String PHONENUMBER_FIELD = "phone_number";
    private static final String FIRSTNAME_FIELD = "first_name";
    private static final String LASTNAME_FIELD = "last_name";
    private static final String USERID_FIELD = "user_id";
    private static final String VCARD_FIELD = "vcard";

    @SerializedName(PHONENUMBER_FIELD)
    private String phoneNumber; ///< Contact's phone number
    @SerializedName(FIRSTNAME_FIELD)
    private String firstName; ///< Contact's first name
    @SerializedName(LASTNAME_FIELD)
    private String lastName; ///< Optional. Contact's last name

    @SerializedName(USERID_FIELD)
    private Long userId; ///< Optional. Contact's user identifier in Telegram
    @SerializedName(VCARD_FIELD)
    private String vCard; ///< Optional. Additional data about the contact in the form of a vCard
}
