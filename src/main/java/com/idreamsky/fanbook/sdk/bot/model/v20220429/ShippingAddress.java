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
public class ShippingAddress implements Serializable {
    private static final String COUNTRY_CODE_FIELD = "country_code";
    private static final String STATE_FIELD = "state";
    private static final String CITY_FIELD = "city";
    private static final String STREET_LINE1_FIELD = "street_line1";
    private static final String STREET_LINE2_FIELD = "street_line2";
    private static final String POST_CODE_FIELD = "post_code";

    @SerializedName(COUNTRY_CODE_FIELD)
    private String countryCode; ///< Two-letter ISO 3166-1 alpha-2 country code
    @SerializedName(STATE_FIELD)
    private String state; ///< State, if applicable
    @SerializedName(CITY_FIELD)
    private String city; ///< City
    @SerializedName(STREET_LINE1_FIELD)
    private String streetLine1; ///< First line for the address
    @SerializedName(STREET_LINE2_FIELD)
    private String streetLine2; ///< Second line for the address
    @SerializedName(POST_CODE_FIELD)
    private String postCode; ///< Address post code
}