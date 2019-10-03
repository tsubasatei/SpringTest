package com.xt.spring.bean.scope;

import com.xt.spring.bean.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeMainTest {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-scope.xml");

        Car car = (Car) ioc.getBean("car");
        Car car2 = (Car) ioc.getBean("car");

        System.out.println(car == car2);
    }
}
