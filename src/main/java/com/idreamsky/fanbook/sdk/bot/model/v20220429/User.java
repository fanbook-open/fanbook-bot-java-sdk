/**
 * Copyright 2022 json.cn
 */
package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2022-04-29 15:44:26
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class User implements Serializable {
    @SerializedName("id")
    private Long id;

    @SerializedName("is_bot")
    private Boolean isBot;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("username")
    private String username;

    @SerializedName("language_code")
    private String languageCode;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("user_token")
    private String userToken;

    @SerializedName("owner_id")
    private Long ownerId;

    @SerializedName("can_join_groups")
    private Boolean canJoinGroups;

    @SerializedName("can_read_all_group_messages")
    private Boolean canReadAllGroupMessages;

    @SerializedName("supports_inline_queries")
    private Boolean supportsInlineQueries;

    @SerializedName("pending")
    private Boolean pending;

    @SerializedName("role_ids")
    private List<String> roleIds;

    @SerializedName("invite_code")
    private String inviteCode;
}