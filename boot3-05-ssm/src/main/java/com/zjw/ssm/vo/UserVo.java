package com.zjw.ssm.vo;

import lombok.Data;

/**
 * @author 朱俊伟
 * @since 2023/12/27 22:44
 */
@Data
public class UserVo {
    private Long id;
    private String loginName;
    private String nickName;
    private String passwd;
}
