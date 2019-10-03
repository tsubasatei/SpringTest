package com.xt.spring.bean.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RelationMainTest {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-relation.xml");

//        Address address = (Address) ioc.getBean("address");
//        System.out.println(address);

        Address address2 = (Address) ioc.getBean("address2");
        System.out.println(address2);

        Address address3 = (Address) ioc.getBean("address3");
        System.out.println(address3);

        Person person = (Person) ioc.getBean("person");
        System.out.println(person);
    }
}
