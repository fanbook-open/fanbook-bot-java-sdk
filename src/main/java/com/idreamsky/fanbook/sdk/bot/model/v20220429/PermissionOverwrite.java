package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;

/**
 * 频道权限覆盖对象
 *
 * @author peng.gan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionOverwrite implements Serializable {
    @SerializedName("id")
    private String id;

    @SerializedName("action_type")
    private String actionType;

    @SerializedName("deny")
    private Integer deny;

    @SerializedName("allows")
    private Integer allows;
}
