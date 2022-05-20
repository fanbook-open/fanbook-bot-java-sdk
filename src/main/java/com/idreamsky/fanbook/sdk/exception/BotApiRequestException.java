package com.idreamsky.fanbook.sdk.exception;

public class BotApiRequestException extends BotClientException{
    private Integer errCode;
    private String errMsg;

    public BotApiRequestException(Integer errorCode, String message) {
        super(message);
    }
}
