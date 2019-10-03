<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.xt.spring.web.bean.Person" %><%--
  Created by IntelliJ IDEA.
  User: XT
  Date: 2019/10/3
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring WEB</title>
</head>
<body>
    <%
        // 1. 从 application （ServletContext）域对象中得到 IOC 容器的实例
        ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(application);

        // 2. 从 IOC 容器中得到 bean
        Person person = ioc.getBean(Person.class);

        // 3. 使用 bean
        person.hello();
    %>
</body>
</html>
