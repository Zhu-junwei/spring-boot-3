package com.atguigu.redis.service;

import com.atguigu.redis.entity.TUser;
import com.atguigu.redis.mapper.UserMapper;
import com.atguigu.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 朱俊伟
 * @since 2023/11/04 13:14
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public TUser getUserById(Long id) {
        if (redisUtil.hasHashKey("user",id.toString())){
            log.info("缓存查询id={}用户",id);
            return (TUser) redisUtil.getHashValue("user",id.toString());
        }

        log.info("数据库查询id={}用户",id);
        TUser tUser = userMapper.getUserById(id);
        redisUtil.putHash("user",tUser.getId().toString(),tUser);
        return tUser;
    }
}
