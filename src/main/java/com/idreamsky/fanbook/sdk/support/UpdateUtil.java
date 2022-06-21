package com.idreamsky.fanbook.sdk.support;


import com.idreamsky.fanbook.sdk.bot.model.v20220429.Message;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.Update;
import com.idreamsky.fanbook.sdk.support.constant.UpdateTypeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class UpdateUtil {

    /**
     * 获取消息类型
     * @param update 消息载体
     * @return enum
     */
    public static UpdateTypeEnum getMessageType(Update update) {
        if (null == update) {
            return UpdateTypeEnum.none;
        }
        Message message = update.getChannelPost();
        if (null == message) {
            return UpdateTypeEnum.none;
        }
        if (null != message.getText()) {
            return UpdateTypeEnum.text;
        } else if (null != message.getPhoto()) {
            return UpdateTypeEnum.photo;
        } else if (null != message.getReaction()) {
            return UpdateTypeEnum.reaction;
        } else if (null != message.getAudio()) {
            return UpdateTypeEnum.audio;
        } else if (null != message.getRichText()) {
            return UpdateTypeEnum.rich_text;
        } else if (null != message.getVideoNote()) {
            return UpdateTypeEnum.video_note;
        } else if (null != message.getVoice()) {
            return UpdateTypeEnum.voice;
        } else if (null != message.getCircleComment()) {
            return UpdateTypeEnum.circle_comment;
        } else if (null != message.getCircleLike()) {
            return UpdateTypeEnum.circle_like;
        } else if (null != message.getCirclePost()) {
            return UpdateTypeEnum.circle_post;
        } else if (null != message.getTopicShare()) {
            return UpdateTypeEnum.topic_share;
        } else if (null != message.getPinnedMessage()) {
            return UpdateTypeEnum.pinnedMessage;
        } else if (null != message.getNewChatMembers()) {
            return UpdateTypeEnum.newChatMembers;
        } else if (null != message.getChatMembersOffline()) {
            return UpdateTypeEnum.chat_members_offline;
        } else if (null != message.getChatMembersOnline()) {
            return UpdateTypeEnum.chat_members_online;
        } else if (null != message.getCircleShareEntity()) {
            return UpdateTypeEnum.circle_share_entity;
        }
        return UpdateTypeEnum.other;
    }

    /**
     * 将消息载体集合按照消息类型分组
     * @param updates 消息载体集合
     * @return k:type;value: updates of split
     */
    public static Map<UpdateTypeEnum, List<Update>> messageGroup(List<Update> updates) {
        if (null == updates || updates.isEmpty()) {
            return new HashMap();
        }
        return updates.stream().collect(Collectors.groupingBy(UpdateUtil::getMessageType));
    }
}
