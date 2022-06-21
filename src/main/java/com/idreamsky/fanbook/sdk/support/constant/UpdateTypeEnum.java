package com.idreamsky.fanbook.sdk.support.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 消息类型枚举
 *
 * @author peng.gan
 */

@Getter
@AllArgsConstructor
public enum UpdateTypeEnum {
    none("none", "空消息"),
    text("text", "普通文本信息"),
    video_note("video_note", "视频信息"),
    photo("photo", "图片"),
    reaction("reaction", "表态消息"),
    audio("audio", "音频文件对象"),
    voice("voice", "音频信息"),
    rich_text("rich_text", "富文本"),
    circle_comment("circle_comment", "圈子评论"),
    chat_members_offline("chat_members_offline", "成员离开"),
    chat_members_online("chat_members_online", "成员进入"),
    pinnedMessage("pinnedMessage", "消息置顶或者取消置顶"),
    newChatMembers("newChatMembers", "新人加入"),
    other("other", "其他，未分类"),
    circle_like("circle_like", "圈子点赞"),
    circle_post("circle_post", "发布圈子"),
    topic_share("topic_share", "主题分享"),
    circle_share_entity("circle_share_entity", "圈子分享");

    String type;
    String desc;
}
