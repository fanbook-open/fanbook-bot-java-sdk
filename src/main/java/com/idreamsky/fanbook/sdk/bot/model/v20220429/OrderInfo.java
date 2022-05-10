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
public class OrderInfo implements Serializable {
    private static final String NAME_FIELD = "name";
    private static final String PHONE_NUMBER_FIELD = "phone_number";
    private static final String EMAIL_FIELD = "email";
    private static final String SHIPPING_ADDRESS_FIELD = "shipping_address";

    @SerializedName(NAME_FIELD)
    private String name; ///< Optional. User name
    @SerializedName(PHONE_NUMBER_FIELD)
    private String phoneNumber; ///< Optional. User's phone number
    @SerializedName(EMAIL_FIELD)
    private String email; ///< Optional. User email
    @SerializedName(SHIPPING_ADDRESS_FIELD)
    private ShippingAddress shippingAddress; ///< Optional. First line for the address
}