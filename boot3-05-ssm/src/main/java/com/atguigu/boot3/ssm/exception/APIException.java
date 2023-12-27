package com.atguigu.boot3.ssm.exception;

import com.atguigu.boot3.ssm.http.AppCode;
import com.atguigu.boot3.ssm.http.StatusCode;
import lombok.Getter;

/**
 * 异常类，这里需要强调一下，code 代表 AppCode 的异常状态码，也就是 2000；
 * msg 代表业务异常，这只是一个大类，一般前端会放到弹窗 title 上；
 * 最后 super(message); 这才是抛出的详细信息，在前端显示在弹窗体中，在 ResultVo 则保存在 data 中。
 */
@Getter
public class APIException extends RuntimeException {
    private int code;
    private String msg;

    // 手动设置异常
    public APIException(StatusCode statusCode, String message) {
        // message用于用户设置抛出错误详情，例如：当前价格-5，小于0
        super(message);
        // 状态码
        this.code = statusCode.getCode();
        // 状态码配套的msg
        this.msg = statusCode.getMsg();
    }

    // 默认异常使用APP_ERROR状态码
    public APIException(String message) {
        super(message);
        this.code = AppCode.APP_ERROR.getCode();
        this.msg = AppCode.APP_ERROR.getMsg();
    }

}