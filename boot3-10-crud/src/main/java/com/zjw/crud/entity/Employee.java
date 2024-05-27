package com.zjw.crud.entity;

import lombok.Data;

/**
 * @author 朱俊伟
 * @Description
 * @since 2023-04-28 16:42
 */
@Data
public class Employee {
    private Long id;
    private String empName;
    private Integer age;
    private String email;
}
