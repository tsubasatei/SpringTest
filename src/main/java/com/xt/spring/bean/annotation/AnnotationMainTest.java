package com.xt.spring.bean.annotation;


import com.xt.spring.bean.annotation.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMainTest {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-annotation.xml");

//        TestObject testObject = (TestObject) ioc.getBean("testObject");
//        System.out.println(testObject);
//
        UserController userController = (UserController) ioc.getBean("userController");
        System.out.println(userController);
        userController.execute();
//
//        UserService userService = (UserService) ioc.getBean("userService");
//        System.out.println(userService);

//        UserRepository userRepository = (UserRepository) ioc.getBean("userRepository");
//        System.out.println(userRepository);
    }
}
