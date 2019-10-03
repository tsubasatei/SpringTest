package com.xt.spring.web;


import com.xt.spring.web.bean.Person;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 从 application 域对象中得到 IOC 容器的引用
        ServletContext servletContext = getServletContext();
        ApplicationContext ioc = (ApplicationContext) servletContext.getAttribute("ApplicationContext");

        // 2. 从 IOC 容器中得到需要的 bean
        Person person = ioc.getBean(Person.class);
        person.hello();
    }
}
