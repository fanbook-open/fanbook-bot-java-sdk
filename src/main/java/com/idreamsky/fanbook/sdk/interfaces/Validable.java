package com.idreamsky.fanbook.sdk.interfaces;

import com.idreamsky.fanbook.sdk.exception.BotArgumentException;

public interface Validable {
    /**
     * 自定义参数校验
     *
     * @throws BotArgumentException
     */
    void validate() throws BotArgumentException;
}
