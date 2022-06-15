package com.idreamsky.fanbook.sdk.bot.method.v20220429;

import com.idreamsky.fanbook.sdk.BotMethod;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import lombok.Data;

import java.io.Serializable;

/**
 * @author peng.gan
 */
@Data
public class EditChannelMethod extends BotMethod {
    @Override
    protected String getEndpoint() {
        return null;
    }

    @Override
    protected HttpMethodType getHttpMethodType() {
        return null;
    }

    @Override
    public Serializable parseResponse(String responseBody) throws BotApiRequestException {
        return null;
    }

    @Override
    public void validate() throws BotArgumentException {

    }
}
