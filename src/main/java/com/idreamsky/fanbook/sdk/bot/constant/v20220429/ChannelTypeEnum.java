package com.idreamsky.fanbook.sdk.bot.constant.v20220429;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 频道类型
 *
 * @author peng.gan
 */

@Getter
@AllArgsConstructor
public enum ChannelTypeEnum {
    TextChannel(0, "普通文本频道"),
    VoiceChannel(1, "语音频道"),
    VideoChannel(2, "视频频道"),
    DMChannel(3, "私聊频道"),
    ClassChannel(4, "频道分类"),
    CircleChannel(5, "圈子"),
    LiveStreamChannel(6, "直播频道"),
    LinkChannel(7, "链接频道"),
    LiveRoomChannel(8, "直播房间"),
    TaskInduction(9, "任务频道（预留）"),
    GroupDMChannel(10, "群"),

    ;

    Integer id;
    String description;


}
