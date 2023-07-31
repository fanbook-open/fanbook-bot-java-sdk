package com.idreamsky.fanbook.sdk.bot.method.v20230731;

import com.idreamsky.fanbook.sdk.bot.method.v20220429.GetUpdatesMethod;
import lombok.Data;

/**
 * <p>
 * 使用这个接口接收服务器里所有的Update，这是一个长轮询的设计方案，
 * 返回一组Update对象，默认情况下只能收到公开频道的NewJoin消息和艾特机器人的消息，
 * 如果想接收所有类型的消息，必须调用SetBotPrivacyMode接口去打开Privacy模式，此时才能接收所有类型的消息，
 * 比如圈子，表态，pin，图片，视频等等消息。
 * </p>
 *
 * @author peng.gan
 */
@Data
public class GetUpdatesV2Method extends GetUpdatesMethod {


    @Override
    protected String getEndpoint() {
        return "v2/getUpdates";
    }
}
