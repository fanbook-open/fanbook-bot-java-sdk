package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

/**
 * @author Ruben Bermudez
 * @version 6.0
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebAppInfo implements Serializable {
    private static final String URL_FIELD = "url";

    @SerializedName(URL_FIELD)
    @NonNull
    private String url; ///< An HTTPS URL of a web app to be opened with additional data as specified at ...

}
