package com.xt.spring.jdbc;

import com.xt.spring.hibernate.service.BookShopService;
import com.xt.spring.hibernate.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

public class SpringHibernateTest {

    private ApplicationContext ioc;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        ioc = new ClassPathXmlApplicationContext("hibernate/ApplicationContext.xml");
        bookShopService = ioc.getBean(BookShopService.class);
        cashier = ioc.getBean(Cashier.class);
    }

    @Test
    public void testCheckout () {
        cashier.checkout("aa", Arrays.asList("1001", "1002"));
    }
    @Test
    public void testPurchase () {
        bookShopService.purchase("aa", "1001");
    }

    @Test
    public void testDataSource () throws SQLException {
        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}
