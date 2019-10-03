package com.xt.spring.bean.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpELMainTest {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-spel.xml");

        Address address = (Address) ioc.getBean("address");
        System.out.println(address);

        Car car = (Car) ioc.getBean("car");
        System.out.println(car);

        Person person = (Person) ioc.getBean("person");
        System.out.println(person);
    }
}
