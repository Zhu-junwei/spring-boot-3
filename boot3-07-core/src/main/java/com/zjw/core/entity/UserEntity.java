package com.zjw.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱俊伟
 * @since 2023/10/30 18:55
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity {

    private String username;
    private String passwd;
}
