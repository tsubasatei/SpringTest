package com.xt.spring.jdbc;

import lombok.Data;

/**
 * 员工类
 */
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;

    private Integer deptId;
}
