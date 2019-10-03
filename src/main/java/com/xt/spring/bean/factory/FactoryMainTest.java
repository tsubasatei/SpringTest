package com.xt.spring.bean.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMainTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-factory.xml");

        Car car = (Car) ioc.getBean("car1");
        System.out.println(car);

        car = (Car) ioc.getBean("car2");
        System.out.println(car);
    }
}
