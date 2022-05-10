package com.idreamsky.fanbook.sdk.support;


import com.idreamsky.fanbook.sdk.bot.model.v20220429.Message;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.Update;
import com.idreamsky.fanbook.sdk.support.constant.UpdateTypeEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class UpdateUtil {

    public static Map<UpdateTypeEnum, List<Update>> messageGroup(List<Update> updates) {
        if (null == updates || updates.isEmpty()) {
            return new HashMap();
        }
        return updates.stream().collect(Collectors.groupingBy(e -> {
            Message message = e.getMessage();
            if (null == message) {
                return UpdateTypeEnum.other;
            }
            if (null != message.getText()) {
                return UpdateTypeEnum.text;
            } else if (null != message.getVideoNote()) {
                return UpdateTypeEnum.video_note;
            } else if (null != message.getPhoto()) {
                return UpdateTypeEnum.photo;
            } else if (null != message.getReaction()) {
                return UpdateTypeEnum.reaction;
            } else if (null != message.getVoice()) {
                return UpdateTypeEnum.voice;
            } else if (null != message.getRichText()) {
                return UpdateTypeEnum.rich_text;
            } else if (null != message.getCircleShareEntity()) {
                return UpdateTypeEnum.circle_share_entity;
            } else if (null != message.getChatMembersOffline()) {
                return UpdateTypeEnum.chat_members_offline;
            } else if (null != message.getChatMembersOnline()) {
                return UpdateTypeEnum.chat_members_online;
            } else if (null != message.getPinnedMessage()) {
                return UpdateTypeEnum.pinnedMessage;
            }
            return UpdateTypeEnum.chat_members_offline;
        }));
    }
}
