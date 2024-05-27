package com.zjw.redis.service;

import com.zjw.redis.entity.TUser;

/**
 * @author 朱俊伟
 * @since 2023/11/04 13:13
 */
public interface UserService {

    TUser getUserById(Long id);
}
