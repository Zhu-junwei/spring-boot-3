package com.atguigu.redis.entity;

import lombok.Data;

/**
 * @author 朱俊伟
 * @since 2023/10/30 12:06
 */
@Data
public class TUser {
    private Long id;
    private String loginName;
    private String nickName;
    private String passwd;
}
