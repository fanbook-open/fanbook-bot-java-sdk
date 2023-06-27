package com.idreamsky.fanbook.sdk.bot.model.v20220429;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class Message implements Serializable {

    @SerializedName("message_id")
    private Long messageId;

    @SerializedName("from")
    private User from;

    @SerializedName("date")
    private Long date;

    @SerializedName("chat")
    private Chat chat;

    @SerializedName("forward_from")
    private User forwardFrom;

    @SerializedName("forward_from_chat")
    private Chat forwardFromChat;

    @SerializedName("forward_from_message_id")
    private Long forwardFromMessageId;

    @SerializedName("forward_signature")
    private String forwardSignature;

    @SerializedName("forward_sender_name")
    private String forwardSenderName;

    @SerializedName("forward_date")
    private Integer forwardDate;

    @SerializedName("reply_to_message")
    private Message replyToMessage;

    @SerializedName("via_bot")
    private User viaBot;

    @SerializedName("edit_date")
    private Long editDate;

    @SerializedName("media_group_id")
    private String mediaGroupId;

    @SerializedName("author_signature")
    private String authorSignature;

    @SerializedName("text")
    private String text;

    @SerializedName("entities")
    private List<MessageEntity> entities;

    @SerializedName("animation")
    private Animation animation;

    @SerializedName("audio")
    private Audio audio;

    @SerializedName("document")
    private Document document;

    @SerializedName("photo")
    private List<PhotoSize> photo;

    @SerializedName("sticker")
    private Sticker sticker;

    @SerializedName("video")
    private Video video;

    @SerializedName("video_note")
    private VideoNote videoNote;

    @SerializedName("voice")
    private Voice voice;

    @SerializedName("caption")
    private String caption;

    @SerializedName("caption_entities")
    private List<MessageEntity> captionEntities;

    @SerializedName("contact")
    private Contact contact;

    @SerializedName("dice")
    private Dice dice;

    @SerializedName("game")
    private Game game;

    @SerializedName("poll")
    private Poll poll;

    @SerializedName("venue")
    private Venue venue;

    @SerializedName("new_chat_members")
    private List<User> newChatMembers;

    @SerializedName("new_join_members")
    private List<User> newJoinMembers;

    @SerializedName("left_chat_member")
    private User leftChatMember;

    @SerializedName("new_chat_title")
    private String newChatTitle;

    @SerializedName("new_chat_photo")
    private List<PhotoSize> newChatPhoto;

    @SerializedName("delete_chat_photo")
    private Boolean deleteChatPhoto;

    @SerializedName("group_chat_created")
    private Boolean groupChatCreated;

    @SerializedName("supergroup_chat_created")
    private Boolean supergroupChatCreated;

    @SerializedName("channel_chat_created")
    private Boolean channelChatCreated;

    @SerializedName("migrate_to_chat_id")
    private Long migrateToChatId;

    @SerializedName("migrate_from_chat_id")
    private Long migrateFromChatId;

    @SerializedName("pinned_message")
    private Message pinnedMessage;

    @SerializedName("invoice")
    private Invoice invoice;

    @SerializedName("reaction")
    private Reaction reaction;

    @SerializedName("chat_members_online")
    private List<User> chatMembersOnline;

    @SerializedName("chat_members_offline")
    private List<User> chatMembersOffline;

    @SerializedName("rich_text")
    private Map richText;

    @SerializedName("circle_post")
    private CirclePostContent circlePost;

    @SerializedName("circle_comment")
    private CircleComment circleComment;

    @SerializedName("circle_like")
    private CircleLike circleLike;

    @SerializedName("topic_share")
    private Object topicShare;

    @SerializedName("circle_share_entity")
    private CircleShareEntity circleShareEntity;

    @SerializedName("interaction_message_card_operation")
    private Object interactionMessageCardOperation;

}
