package com.zjw.ssm.mapper;

import com.zjw.ssm.bean.TUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author 朱俊伟
 * @since 2023/10/30 12:08
 */
public interface UserMapper {

    TUser findById(@Param("id") Integer id);
}
