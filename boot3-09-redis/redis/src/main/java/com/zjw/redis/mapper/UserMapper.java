package com.zjw.redis.mapper;

import com.zjw.redis.entity.TUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author 朱俊伟
 * @since 2023/11/04 13:09
 */
public interface UserMapper {
    TUser getUserById(@Param("id") Long id);
}

