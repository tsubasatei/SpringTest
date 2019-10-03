package com.xt.spring.jdbc;

import com.xt.spring.web.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringWebTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:web/applicationContext.xml");

        Person person = (Person) ioc.getBean("person");
        person.hello();
    }
}
