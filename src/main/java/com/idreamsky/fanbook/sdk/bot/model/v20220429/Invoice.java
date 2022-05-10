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
public class Invoice implements Serializable {
    private static final String TITLE_FIELD = "title";
    private static final String DESCRIPTION_FIELD = "description";
    private static final String START_PARAMETER_FIELD = "start_parameter";
    private static final String CURRENCY_FIELD = "currency";
    private static final String TOTAL_AMOUNT_FIELD = "total_amount";
    private static final String PHOTO_FIELD = "photo";

    @SerializedName(TITLE_FIELD)
    private String title; ///< Product name
    @SerializedName(DESCRIPTION_FIELD)
    private String description; ///< Product description
    /**
     * Unique bot deep-linking parameter that can be used to generate this invoice; may be empty
     */
    @SerializedName(START_PARAMETER_FIELD)
    private String startParameter;
    @SerializedName(CURRENCY_FIELD)
    private String currency; ///< Three-letter ISO 4217 currency code
    /**
     * Total price in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145.
     */
    @SerializedName(TOTAL_AMOUNT_FIELD)
    private Integer totalAmount; ///< Goods total price in minimal quantity of the currency
    @SerializedName(PHOTO_FIELD)
    private PhotoSize photo; ///< Optional. Goods photo
}