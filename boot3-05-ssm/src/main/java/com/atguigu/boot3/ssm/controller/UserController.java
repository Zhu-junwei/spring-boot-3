package com.atguigu.boot3.ssm.controller;

import com.atguigu.boot3.ssm.bean.TUser;
import com.atguigu.boot3.ssm.config.NotControllerResponseAdvice;
import com.atguigu.boot3.ssm.exception.APIException;
import com.atguigu.boot3.ssm.http.AppCode;
import com.atguigu.boot3.ssm.service.UserService;
import com.atguigu.boot3.ssm.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱俊伟
 * @date 2023/10/30 12:20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findById")
    public TUser findById(Integer id){
        TUser user = userService.findById(id);
        if (user == null) {
            throw new APIException(AppCode.USER_NOT_FOUND_ERROR, "用户不存在:" + id);
        }
        return user;
    }

    @GetMapping("/findByVo")
    public TUser findByVo(UserVo userVo){
        TUser user = userService.findById(userVo.getId().intValue());
        return user;
    }

    @NotControllerResponseAdvice
    @GetMapping("/getUserName")
    public String getUserName(Integer id){
        TUser user = userService.findById(id);
        return user.getLoginName();
    }
}
