package com.idreamsky.fanbook.sdk.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BotClientEnum {
    OK(0, "success"),
    FAIL(1, "fail"),
    picture_system_error(1, "图片系统出错"),
    signature_failed(901, "签名失败"),
    non_IP_self_list(902, "非IP自名单"),
    account_blocked(903, "此账号已被封禁，请联系客服"),
    success(1000, "成功"),
    miss_argument(1001, "缺乏叁数"),
    failed_to_create_channel(1002, "频道创建失败"),
    user_creation_failed(1003, "用户创建失败 "),
    account_not_exist(1004, "账号不存在"),
    password_error(1005, "密码错误"),
    failed_to_delete_channel(1006, "频道删除失败"),
    help_desk_user_does_not_exist(1007, "服务台用户不存在 "),


    ;
    Integer code;
    String desc;
}
