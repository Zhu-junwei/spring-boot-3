package com.zjw.redis.service;

import com.zjw.redis.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 朱俊伟
 * @since 2023/11/04 13:13
 */
public interface UserService extends IService<TUser> {

    TUser getUserByName(String name);

    TUser saveUser(TUser user);
}
