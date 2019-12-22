package com.xt.spring.jdbc;

import com.xt.spring.tx.BookShopDao;
import com.xt.spring.tx.BookShopService;
import com.xt.spring.tx.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * 事务管理是企业级应用程序开发中必不可少的技术,  用来确保数据的完整性和一致性.
 * 事务就是一系列的动作, 它们被当做一个单独的工作单元. 这些动作要么全部完成, 要么全部不起作用
 * 事务的四个关键属性(ACID)
 *      原子性(atomicity): 事务是一个原子操作, 由一系列动作组成. 事务的原子性确保动作要么全部完成要么完全不起作用.
 *      一致性(consistency): 一旦所有事务动作完成, 事务就被提交. 数据和资源就处于一种满足业务规则的一致性状态中.
 *      隔离性(isolation): 可能有许多事务会同时处理相同的数据, 因此每个事物都应该与其他事务隔离开来, 防止数据损坏.
 *      持久性(durability): 一旦事务完成, 无论发生什么系统错误, 它的结果都不应该受到影响. 通常情况下, 事务的结果被写到持久化存储器中.
 */
public class SpringTransactionTest {

    private ApplicationContext ioc;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        ioc = new ClassPathXmlApplicationContext("jdbc/applicationContext.xml");
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
