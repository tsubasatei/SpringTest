package com.xt.spring;


import com.xt.spring.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        //1. 创建 Spring 的 IOC 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2. 从 IOC 容器中获取 bean 的实例
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");

        //3. 使用 bean
        helloWorld.hello();
    }
}
