package com.atguigu.controller;

import com.atguigu.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @since 2023/10/24 22:46
 */
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/a*/b?/{p1:[a-f]+}")
    public String hello(HttpServletRequest request,
                        @PathVariable("p1") String path) {

        log.info("路径变量p1： {}", path);
        //获取请求路径
        String uri = request.getRequestURI();
        return uri;
    }

    @GetMapping("/person")
    public Person person(){
        return Person.builder()
                .id(1L)
                .name("张三")
                .email("110@gamil.com")
                .age(18)
                .build();
    }

    @GetMapping("/exception")
    public String exception(){
        int i = 1 / 0;
        return "异常";
    }

    /**
     * 只能处理当前Controller发生的错误
     */
//    @ExceptionHandler
    public String handlerException(Exception e){
        return "exception...." + e.getMessage();
    }
}
