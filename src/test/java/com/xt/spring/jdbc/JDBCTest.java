package com.xt.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    private ApplicationContext ioc;
    private JdbcTemplate jdbcTemplate;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ioc = new ClassPathXmlApplicationContext("jdbc/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
        employeeDao = ioc.getBean(EmployeeDao.class);
        departmentDao = ioc.getBean(DepartmentDao.class);
        namedParameterJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
    }

    /**
     * 使用具名参数时，可以使用 update(String sql, SqlParameterSource sqlParameterSource) 方法进行更新操作
     * 1. SQL 语句中的参数名和类的属性一致
     * 2. 使用 SqlParameterSource 的  BeanPropertyParameterSource 实现类作为参数
     */
    @Test
    public void testNamedParameterJdbcTemplate2 () {
        String sql = "insert into employee(lastName, email, gender, d_id) values (:lastName, :email, :gender, :deptId)";
        Employee employee = new Employee();
        employee.setLastName("GG");
        employee.setEmail("gg@163.com");
        employee.setGender(1);
        employee.setDeptId(1);
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    /**
     * 可以给参数起名字
     * 1. 好处：若有多个参数，则不用再去对应位置，直接对应参数名，便于维护
     * 2. 缺点：较为麻烦
     */
    @Test
    public void testNamedParameterJdbcTemplate () {
        String sql = "insert into employee(lastName, email, gender, d_id) values (:ln, :email, :gender, :did)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ln", "FF");
        paramMap.put("email", "ff@163.com");
        paramMap.put("gender", 0);
        paramMap.put("did", 1);

        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    @Test
    public void testDepartmentDao () {
        Department department = departmentDao.getById(1);
        System.out.println(department);
    }

    @Test
    public void testEmployeeDao () {
        Employee employee = employeeDao.getById(8);
        System.out.println(employee);
    }

    /**
     * 获取单个列的值，或做统计查询
     * 使用 queryForObject(String sql, Class<T> requiredType)
     */
    @Test
    public void testCount () {
        String sql = "SELECT count(id) FROM employee";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    /**
     * 查到实体类的集合
     * 注意调用的不是 queryForList
     */
    @Test
    public void testQueryForList () {
        String sql = "SELECT id, lastName,EMAIL,gender, d_id 'department.id' FROM employee WHERE id>?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, 6);
        System.out.println(employees);
    }

    /**
     * 从数据库中获取一条记录，实际得到对应的一个对象
     * X 注意不是调用 queryForObject(String sql, Class<Employee> requiredType, Object... args) 风法
     * 而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
     * 1. 其中的 RowMapper 指定如何去映射结果集的行，常用的实现类为 BeanPropertyRowMapper
     * 2. 使用 SQL 中列的别名完成列明和类的属性名的映射，例如 last_name lastName
     * 3. 不支持级联属性。 JdbcTemplate 到底是一个 JDBC 的小工具，而不是 ORM 框架
     */
    @Test
    public void testQueryForObject () {
        String sql = "SELECT id, lastName,EMAIL,gender, d_id 'department.id' FROM employee WHERE id=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 7);
        System.out.println(employee);
    }
    /**
     * 执行批量更新：批量的 DELETE
     * 最后一个参数是 Object[] 的 List 类型：因为修改一条记录需要一个 Object 的数组，那么多条就需要多个 Object 的数组
     */
    @Test
    public void testBatchUpdate () {
        String sql = "INSERT INTO employee(lastName, email, gender, d_id) VALUES (?, ?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new  Object[] {"AA", "aa@163.com", 1, 1});
        batchArgs.add(new  Object[] {"BB", "bb@163.com", 0, 2});
        batchArgs.add(new  Object[] {"CC", "cc@163.com", 0, 3});
        batchArgs.add(new  Object[] {"DD", "dd@163.com", 1, 2});
        batchArgs.add(new  Object[] {"EE", "ee@163.com", 1, 3});

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
    /**
     * 执行 INSERT,UPDATE,DELETE
     */
    @Test
    public void testUpdate () {
        String sql = "UPDATE employee SET lastName=? WHERE id=?";
        jdbcTemplate.update(sql, "Jack", 3);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }

}
