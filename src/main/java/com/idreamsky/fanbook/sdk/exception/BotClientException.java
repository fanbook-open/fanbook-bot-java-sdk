package com.idreamsky.fanbook.sdk.exception;

public class BotClientException extends RuntimeException {


    public BotClientException(String message) {
        super(message);
    }


    public BotClientException(String message, Throwable cause) {
        super(message, cause);
    }

}
