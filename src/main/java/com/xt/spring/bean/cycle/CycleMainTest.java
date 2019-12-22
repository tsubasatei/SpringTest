package com.xt.spring.bean.cycle;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IOC 容器对 Bean 的生命周期进行管理的过程:
 *      通过构造器或工厂方法创建 Bean 实例
 *      为 Bean 的属性设置值和对其他 Bean 的引用
 *      将 Bean 实例传递给 Bean 后置处理器的 postProcessBeforeInitialization 方法
 *      调用 Bean 的初始化方法
 *      将 Bean 实例传递给 Bean 后置处理器的 postProcessAfterInitialization方法
 *      Bean 可以使用了
 *      当容器关闭时, 调用 Bean 的销毁方法
 */
public class CycleMainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans/beans-cycle.xml");

        System.out.println("----------");
        Car car = (Car) ioc.getBean("car");
        System.out.println(car);

        ioc.close();
    }
}
