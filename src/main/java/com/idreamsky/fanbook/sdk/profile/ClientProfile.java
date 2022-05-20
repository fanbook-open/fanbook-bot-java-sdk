package com.idreamsky.fanbook.sdk.profile;

import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpConfig;
import com.idreamsky.fanbook.sdk.interfaces.Validable;
import lombok.Data;

/**
 * fanbook SDK 客户端配置参数
 *
 * @author peng.gan
 */
@Data
public class ClientProfile implements Validable {

    /**
     * Fanbook bot rest api 网络协议
     */
    private String httpProtocolType = "https";

    /**
     * Fanbook bot 服务器域名
     */
    private String domain = "a1.fanbook.mobi";

    private String botToken;

    private String clientKey;

    private String clientSecret;

    private HttpConfig httpConfig;

    private Long botId;

    public static ClientProfile getDefaultProfile() {
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpConfig(new HttpConfig());
        return clientProfile;
    }

    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException client本地参数校验失败异常
     */
    @Override
    public void validate() throws BotArgumentException {
        if (null == httpProtocolType || httpProtocolType.isEmpty()) {
            throw new BotArgumentException("httpProtocolType of client profile must not be null");
        }
        if (null == domain || domain.isEmpty()) {
            throw new BotArgumentException("domain of client profile must not be null");
        }
        if (null == botToken || botToken.isEmpty()) {
            throw new BotArgumentException("botToken of client profile must not be null");
        }
        if (null == clientKey || clientKey.isEmpty()) {
            throw new BotArgumentException("clientKey of client profile must not be null");
        }
        if (null == clientSecret || clientSecret.isEmpty()) {
            throw new BotArgumentException("clientSecret of client profile must not be null");
        }
        if (null == httpConfig) {
            throw new BotArgumentException("httpConfig of client profile must not be null");
        }
        if (null == botId) {
            throw new BotArgumentException("botId of client profile must not be null");
        }
    }
}
