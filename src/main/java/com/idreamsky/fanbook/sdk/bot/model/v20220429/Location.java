package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {

    private static final String LONGITUDE_FIELD = "longitude";
    private static final String LATITUDE_FIELD = "latitude";
    private static final String HORIZONTALACCURACY_FIELD = "horizontal_accuracy";
    private static final String LIVEPERIOD_FIELD = "live_period";
    private static final String HEADING_FIELD = "heading";
    private static final String PROXMITYALERTRADIUS_FIELD = "proximity_alert_radius";

    @SerializedName(LONGITUDE_FIELD)
    @NonNull
    private Double longitude; ///< Longitude as defined by sender
    @SerializedName(LATITUDE_FIELD)
    @NonNull
    private Double latitude; ///< Latitude as defined by sender
    /**
     * Optional.
     * The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @SerializedName(HORIZONTALACCURACY_FIELD)
    private Double horizontalAccuracy;
    /**
     * Optional.
     * Time relative to the message sending date, during which the location will be updated, in seconds.
     * For active live locations only.
     */
    @SerializedName(LIVEPERIOD_FIELD)
    private Integer livePeriod;
    /**
     * Optional.
     * The direction in which user is moving, in degrees; 1-360. For active live locations only.
     */
    @SerializedName(HEADING_FIELD)
    private Integer heading;
    /**
     * Optional.
     * Maximum distance for proximity alerts about approaching another chat member, in meters.
     * For sent live locations only.
     */
    @SerializedName(PROXMITYALERTRADIUS_FIELD)
    private Integer proximityAlertRadius;
}