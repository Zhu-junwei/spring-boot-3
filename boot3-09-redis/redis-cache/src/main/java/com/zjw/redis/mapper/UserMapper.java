package com.zjw.redis.mapper;

import com.zjw.redis.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 朱俊伟
 * @since 2023/11/04 13:09
 */
@Mapper
public interface UserMapper extends BaseMapper<TUser> {

}

