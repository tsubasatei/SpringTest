package com.xt.spring.bean.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-factorybean.xml");

        Car car = ioc.getBean("car", Car.class);
        System.out.println(car);
    }
}
