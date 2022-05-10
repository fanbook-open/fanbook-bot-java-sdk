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
public class Venue implements Serializable {
    private static final String LOCATION_FIELD = "location";
    private static final String TITLE_FIELD = "title";
    private static final String ADDRESS_FIELD = "address";
    private static final String FOURSQUAREID_FIELD = "foursquare_id";
    private static final String FOURSQUARETYPE_FIELD = "foursquare_type";
    private static final String GOOGLEPLACEID_FIELD = "google_place_id";
    private static final String GOOGLEPLACETYPE_FIELD = "google_place_type";

    @SerializedName(LOCATION_FIELD)
    private Location location; ///< Venue location
    @SerializedName(TITLE_FIELD)
    private String title; ///< Name of the venue
    @SerializedName(ADDRESS_FIELD)
    private String address; ///< Address of the venue
    @SerializedName(FOURSQUAREID_FIELD)
    private String foursquareId; ///< Optional. Foursquare identifier of the venue
    @SerializedName(FOURSQUARETYPE_FIELD)
    private String foursquareType; ///< Optional. Foursquare type of the venue.
    @SerializedName(GOOGLEPLACEID_FIELD)
    private String googlePlaceId; ///< Optional. Google Places identifier of the venue
    @SerializedName(GOOGLEPLACETYPE_FIELD)
    private String googlePlaceType; ///< Optional. Google Places type of the venue. (See supported types.)
}