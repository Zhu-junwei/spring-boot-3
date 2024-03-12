package com.atguigu.redis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 朱俊伟
 * @since 2023/10/30 12:06
 */
@Data
@Builder
@TableName("t_user")
public class TUser implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String loginName;
    private String nickName;
    private String passwd;
}
