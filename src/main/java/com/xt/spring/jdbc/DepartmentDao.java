package com.xt.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * 不推荐使用 JdbcDaoSupport,而推荐直接使用 JdbcRTemplate 作为 Dao 类的成员变量
 */
@Repository
public class DepartmentDao extends JdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public Department getById(Integer id) {
        String sql = "SELECT id, departmentName FROM department WHERE id = ?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
        Department department = getJdbcTemplate().queryForObject(sql, rowMapper, id);
        return department;

    }
}
