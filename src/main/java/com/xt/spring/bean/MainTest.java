package com.xt.spring.bean;


import com.xt.spring.bean.collections.DataSource;
import com.xt.spring.bean.collections.NewPerson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        /**
         * 1. 创建 Spring 的 IOC 容器
         * ApplicationContext 代表 IOC 容器， 是 BeanFactory 的子接口
         * ClassPathXmlApplicationContext：是 ApplicationContext 接口的实现类，该实现类从类路径下加载配置文件
         */
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans/applicationContext.xml");

        //2. 从 IOC 容器中获取 bean 的实例
        // 利用 id 定位到容器中的 Bean
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");

        // 利用类型返回 IOC 容器中的 Bean, 但要求 IOC 容器中必须只能有一个该类型的 Bean
//        HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);

        //3. 使用 bean
        helloWorld.hello();

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        car = (Car) ctx.getBean("car2");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        person = (Person) ctx.getBean("person2");
        System.out.println(person);

        com.xt.spring.bean.collections.Person person3 = (com.xt.spring.bean.collections.Person) ctx.getBean("person3");
        System.out.println(person3);

        NewPerson newPerson = (NewPerson) ctx.getBean("newPerson");
        System.out.println(newPerson);

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);

        com.xt.spring.bean.collections.Person person4 = (com.xt.spring.bean.collections.Person) ctx.getBean("person4");
        System.out.println(person4);

        com.xt.spring.bean.collections.Person person5 = (com.xt.spring.bean.collections.Person) ctx.getBean("person5");
        System.out.println(person5);
    }
}
