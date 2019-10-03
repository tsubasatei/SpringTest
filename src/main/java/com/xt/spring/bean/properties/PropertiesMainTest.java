package com.xt.spring.bean.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class PropertiesMainTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-properties.xml");

        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        System.out.println(dataSource);
    }
}
