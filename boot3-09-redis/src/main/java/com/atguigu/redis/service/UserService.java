package com.atguigu.redis.service;

import com.atguigu.redis.entity.TUser;

/**
 * @author 朱俊伟
 * @date 2023/11/04 13:13
 */
public interface UserService {

    TUser getUserById(Long id);
}
