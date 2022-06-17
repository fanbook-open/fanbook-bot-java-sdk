package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * <p>
 * This object contains information about incoming shipping query.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShippingQuery implements Serializable {
    private static final String ID_FIELD = "id";
    private static final String FROM_FIELD = "from";
    private static final String INVOICE_PAYLOAD_FIELD = "invoice_payload";
    private static final String SHIPPING_ADDRESS_FIELD = "shipping_address";

    @SerializedName(ID_FIELD)
    private String id; ///< Unique query identifier
    @SerializedName(FROM_FIELD)
    private User from; ///< User who sent the query
    @SerializedName(INVOICE_PAYLOAD_FIELD)
    private String invoicePayload; ///< Bot specified invoice payload
    @SerializedName(SHIPPING_ADDRESS_FIELD)
    private ShippingAddress shippingAddress; ///< User specified shipping address
}
