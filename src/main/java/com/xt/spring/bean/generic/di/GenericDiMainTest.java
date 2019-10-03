package com.xt.spring.bean.generic.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GenericDiMainTest {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-generic-di.xml");

        UserService userService = (UserService) ioc.getBean("userService");
        userService.add();
    }
}
