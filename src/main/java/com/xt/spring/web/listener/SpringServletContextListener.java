package com.xt.spring.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringServletContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce) {

        // 0. 获取 Spring 配置文件的名称
        ServletContext servletContext = sce.getServletContext();
        String config = servletContext.getInitParameter("configLocation");

        // 1. 创建 IOC 容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext(config);
        // 2. 把 IOC 容器放在 ServletContext 的一个属性中
        servletContext.setAttribute("ApplicationContext", ioc);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
