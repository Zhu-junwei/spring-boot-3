package com.atguigu.boot3.ssm.service.impl;

import com.atguigu.boot3.ssm.bean.TUser;
import com.atguigu.boot3.ssm.mapper.UserMapper;
import com.atguigu.boot3.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 朱俊伟
 * @since 2023/12/27 22:26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public TUser findById(Integer id){
        TUser user = userMapper.findById(id);
        return user;
    }

}
