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
public class SuccessfulPayment implements Serializable {
    private static final String CURRENCY_FIELD = "currency";
    private static final String TOTAL_AMOUNT_FIELD = "total_amount";
    private static final String INVOICE_PAYLOAD_FIELD = "invoice_payload";
    private static final String SHIPPING_OPTION_ID_FIELD = "shipping_option_id";
    private static final String ORDER_INFO_FIELD = "order_info";
    private static final String TELEGRAM_PAYMENT_CHARGE_ID_FIELD = "telegram_payment_charge_id";
    private static final String PROVIDER_PAYMENT_CHARGE_ID_FIELD = "provider_payment_charge_id";

    @SerializedName(CURRENCY_FIELD)
    private String currency; ///< Three-letter ISO 4217 currency code
    /**
     * Total price in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145.
     */
    @SerializedName(TOTAL_AMOUNT_FIELD)
    private Integer totalAmount;
    @SerializedName(INVOICE_PAYLOAD_FIELD)
    private String invoicePayload; ///< Bot specified invoice payload
    @SerializedName(SHIPPING_OPTION_ID_FIELD)
    private String shippingOptionId; ///< Optional. Identifier of a chosen by user shipping option
    @SerializedName(ORDER_INFO_FIELD)
    private OrderInfo orderInfo; ///< Optional. Order info provided by the user
    @SerializedName(TELEGRAM_PAYMENT_CHARGE_ID_FIELD)
    private String telegramPaymentChargeId; ///< Telegram payment identifier
    @SerializedName(PROVIDER_PAYMENT_CHARGE_ID_FIELD)
    private String providerPaymentChargeId; ///< Provider payment identifier
}
