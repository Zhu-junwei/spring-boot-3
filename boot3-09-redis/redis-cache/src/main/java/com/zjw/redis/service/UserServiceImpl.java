package com.zjw.redis.service;

import com.zjw.redis.config.RedisConfig;
import com.zjw.redis.entity.TUser;
import com.zjw.redis.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author 朱俊伟
 * @since 2023/11/04 13:14
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, TUser> implements UserService {

    @Autowired
    UserMapper userMapper;

    /*
        @Cacheable(value = "user", key = "#id")
            user::id
        @Cacheable("user")
            user::id
        @Cacheable(value = "user", keyGenerator = "keyGenerator")
            user::自定义的key
        @Cacheable(value={"users"}, key="#user.id", condition="#user.id%2==0")
            只有当user的id为偶数时才会进行缓存
     */
    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE, key = "'user:'+#id", condition = "#result==null")
    public TUser getById(Long id) {
        log.info("查询用户,id：{}", id);
        return super.getById(id);
    }

    /**
     * 根据名字查询用户
     */
    @Override
    @Cacheable(value = RedisConfig.REDIS_KEY_DATABASE, key = "'user:LoginName:'+#name", unless = "#result==null")
    public TUser getUserByName(String name) {
        log.info("查询用户,用户名：{}", name);
        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TUser::getLoginName, name);
        return baseMapper.selectOne(queryWrapper);
    }

    /**
     * 保存用户
     */
    @Override
    @CachePut(value = RedisConfig.REDIS_KEY_DATABASE, key = "'user:'+#result.id", unless = "#result.id!=null")
    public TUser saveUser(TUser user) {
        log.info("保存用户,用户名：{}", user.getLoginName());
        super.save(user);
        return user;
    }

    /**
     * 更新用户信息
     */
    @CachePut(value = RedisConfig.REDIS_KEY_DATABASE, key = "'user:'+#user.id", condition = "#result == true")
    public boolean update(TUser user) {
        log.info("更新用户,id：{}", user.getId());
        return super.updateById(user);
    }

    /**
     * 删除用户
     */
    @CacheEvict(value = RedisConfig.REDIS_KEY_DATABASE, key = "'user:'+#id")
    public boolean removeById(Long id){
        log.info("删除用户,id：{}", id);
        return super.removeById(id);
    }
}
