package com.xt.spring.jdbc;


import com.xt.spring.tx.xml.BookShopDao;
import com.xt.spring.tx.xml.service.BookShopService;
import com.xt.spring.tx.xml.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionXMLTest {

    private ApplicationContext ioc;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        ioc = new ClassPathXmlApplicationContext("jdbc/applicationContext-tx-xml.xml");
        bookShopDao = (BookShopDao) ioc.getBean("bookShopDao");
        bookShopService = (BookShopService) ioc.getBean("bookShopService");
        cashier = (Cashier) ioc.getBean("cashier");
    }

    @Test
    public void testCheckout () {
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    @Test
    public void testPurchase () {
        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void testFindBookPriceByIsbn () {
        int price = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println(price);
    }

    @Test
    public void testUpdateBookStock () {
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testUpdateUserAccount () {
        bookShopDao.updateUserAccount("AA", 100);
    }
}
