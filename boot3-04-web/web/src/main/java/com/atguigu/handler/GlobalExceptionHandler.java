package com.atguigu.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 集中处理所有@Controller发生的错误
 * @author 朱俊伟
 * @since 2023/10/26 12:24
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e){
        return "发生错误，原因:" + e.getMessage();
    }

}
