package com.xt.spring.bean.cycle;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CycleMainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-cycle.xml");

        Car car = (Car) ioc.getBean("car");
        System.out.println(car);

        ioc.close();
    }
}
