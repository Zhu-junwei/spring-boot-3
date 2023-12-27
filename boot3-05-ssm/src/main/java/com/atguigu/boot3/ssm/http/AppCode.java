package com.atguigu.boot3.ssm.http;

import lombok.Getter;

@Getter
public enum  AppCode implements StatusCode {

    APP_ERROR(2000, "业务异常"),
    USER_NOT_FOUND_ERROR(2001, "用户不存在");

    private int code;
    private String msg;

    AppCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}