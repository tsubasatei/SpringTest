package com.xt.spring.aop.xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {

        // 1. 创建 Spring 的 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop/ApplicationContext-xml.xml");

        // 2. 从 IOC 容器中获取 bean 的实例
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ioc.getBean("arithmeticCalculator");

        System.out.println(arithmeticCalculator.getClass().getName()); // com.sun.proxy.$Proxy6

        // 3. 使用 bean
        int result = arithmeticCalculator.add(3, 6);
        System.out.println("result : " + result);

        result = arithmeticCalculator.div(12, 0);
        System.out.println("result : " + result);
    }
}
