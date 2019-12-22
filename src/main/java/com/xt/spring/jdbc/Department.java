package com.xt.spring.jdbc;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门类
 */
@Data
public class Department implements Serializable {
    private Integer id;
    private String departmentName;
}
