package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ChatMember implements Serializable {

    @SerializedName("user")
    private User user;

    @SerializedName("status")
    private String status;

    @SerializedName("roles")
    private List<GuildRole> roles;

    @SerializedName("custom_title")
    private String customTitle;

    @SerializedName("until_date")
    private Long untilDate;

    @SerializedName("can_manage_guild")
    private Boolean canManageGuild;

    @SerializedName("can_manage_channels")
    private Boolean canManageChannels;

    @SerializedName("can_manage_roles")
    private Boolean canManageRoles;

    @SerializedName("can_manage_emojis")
    private Boolean canManageEmojis;

    @SerializedName("can_be_edited")
    private Boolean canBeEdited;

    @SerializedName("can_post_messages")
    private Boolean canPostMessages;

    @SerializedName("can_edit_messages")
    private Boolean canEditMessages;

    @SerializedName("can_delete_messages")
    private Boolean canDeleteMessages;

    @SerializedName("can_restrict_members")
    private Boolean canRestrictMembers;

    @SerializedName("can_promote_members")
    private Boolean canPromoteMembers;

    @SerializedName("can_change_info")
    private Boolean canChangeInfo;

    @SerializedName("can_invite_users")
    private Boolean canInviteUsers;

    @SerializedName("can_pin_messages")
    private Boolean canPinMessages;

    @SerializedName("is_member")
    private Boolean isMember;

    @SerializedName("can_send_messages")
    private Boolean canSendMessages;

    @SerializedName("can_send_media_messages")
    private Boolean canSendMediaMessages;

    @SerializedName("can_send_polls")
    private Boolean canSendPolls;

    @SerializedName("can_send_other_messages")
    private Boolean canSendOtherMessages;

    @SerializedName("can_add_web_page_previews")
    private Boolean canAddWebPagePreviews;


}
