package com.xt.spring.bean.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireMainTest {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-autowire.xml");

        Person person = (Person) ioc.getBean("person");
        System.out.println(person);

    }
}
