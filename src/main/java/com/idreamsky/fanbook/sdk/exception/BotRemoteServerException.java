package com.idreamsky.fanbook.sdk.exception;


/**
 * Fanbook服务器不可使用异常
 */
public class BotRemoteServerException extends RuntimeException {
    public BotRemoteServerException(String message) {
        super(message);
    }


    public BotRemoteServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
