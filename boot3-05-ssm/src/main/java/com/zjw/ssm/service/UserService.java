package com.zjw.ssm.service;

import com.zjw.ssm.bean.TUser;

/**
 * @author 朱俊伟
 * @since 2023/12/27 22:26
 */
public interface UserService {

    TUser findById(Integer id);

}
