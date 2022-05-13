package com.idreamsky.fanbook.sdk;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BotClientEnum {
    OK(0, "success"),
    FAIL(1, "fail");

    Integer code;
    String desc;
}
