package com.xt.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 切面(Aspect):  横切关注点(跨越应用程序多个模块的功能)被模块化的特殊对象
 * 通知(Advice):  切面必须要完成的工作
 * 目标(Target): 被通知的对象
 * 代理(Proxy): 向目标对象应用通知之后创建的对象
 * 连接点（JoinPoint）：程序执行的某个特定位置：如类某个方法调用前、调用后、方法抛出异常后等。
 *      连接点由两个信息确定：方法表示的程序执行点；相对点表示的方位。
 *      例如 ArithmeticCalculator#add() 方法执行前的连接点，执行点为 ArithmeticCalculator#add()； 方位为该方法执行前的位置
 * 切点（pointcut）：每个类都拥有多个连接点：
 *      例如 ArithmeticCalculator 的所有方法实际上都是连接点，即连接点是程序类中客观存在的事物。
 *      AOP 通过切点定位到特定的连接点。类比：连接点相当于数据库中的记录，切点相当于查询条件。
 *      切点和连接点不是一对一的关系，一个切点匹配多个连接点，
 *      切点通过 org.springframework.aop.Pointcut 接口进行描述，它使用类和方法作为连接点的查询条件。
 */
public class MainTest {
    public static void main(String[] args) {

        // 1. 创建 Spring 的 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop/ApplicationContext.xml");

        // 2. 从 IOC 容器中获取 bean 的实例
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ioc.getBean("arithmeticCalculator");

        System.out.println(arithmeticCalculator.getClass().getName()); // com.sun.proxy.$Proxy17

        // 3. 使用 bean
        int result = arithmeticCalculator.add(3, 6);
        System.out.println("result : " + result);

        result = arithmeticCalculator.div(12, 6);
        System.out.println("result : " + result);
    }
}
