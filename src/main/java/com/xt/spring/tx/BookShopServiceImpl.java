package com.xt.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * 支持事务处理: 为方法添加 @Transactional 注解. 根据 Spring AOP 基于代理机制, 只能标注公有方法.
 * 可以在方法或者类级别上添加 @Transactional 注解. 当把这个注解应用到类上时, 这个类中的所有公共方法都会被定义成支持事务处理的.
 * 在 Bean 配置文件中只需要启用 <tx:annotation-driven> 元素, 并为之指定事务管理器就可以了.
 * 如果事务处理器的名称是 transactionManager, 就可以在<tx:annotation-driven> 元素中省略 transaction-manager 属性. 这个元素会自动检测该名称的事务处理器.
 *
 * 并发事务所导致的问题可以分为下面三种类型:
 *      脏读: 对于两个事物 T1, T2, T1  读取了已经被 T2 更新但 还没有被提交的字段. 之后, 若 T2 回滚, T1读取的内容就是临时且无效的.
 *      不可重复读:对于两个事物 T1, T2, T1  读取了一个字段, 然后 T2 更新了该字段. 之后, T1再次读取同一个字段, 值就不同了.
 *      幻读:对于两个事物 T1, T2, T1  从一个表中读取了一个字段, 然后 T2 在该表中插入了一些新的行. 之后, 如果 T1 再次读取同一个表, 就会多出几行.
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 添加事务注解: @Transactional
     *
     * 1. 使用 propagation 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时，如何使用事务
     *      默认值为 REQUIRED, 即使用调用方法的事务
     *      REQUIRES_NEW：使用自己的事务，调用的事务方法的事务被挂起
     *      SUPPORTS、 NOT_SUPPORTS、 MANDATORY、 NEVER、 NESTED
     *
     * 2. 使用 isolation 指定事务的隔离级别，最常用的取值为 READ_COMMITTED
     *      DEFAULT、READ_UNCOMMITTED、READ_COMMITTED、REPEATABLE_READ、SERIALIZABLE
     *
     * 3. 默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置
     *      通常情况下取默认值即可
     *      rollbackFor:  遇到时必须进行回滚
     *      noRollbackFor: 一组异常类，遇到时必须不回滚
     *
     * 4. 使用 readOnly 指定事务是否为只读.
     *      true 表示这个事务只读取数据但不更新数据，这样可以帮助数据引擎优化事务。
     *      若真的是一个只读取数据库值的方法，应设置 readOnly=true
     *
     * 5. 使用 timeout 指定强制回滚事务可以占用的时间，单位 秒
     * 
     * @param username
     * @param isbn
     */
//    @Transactional(propagation = Propagation.REQUIRES_NEW,
//            isolation = Isolation.READ_COMMITTED,
//            noRollbackFor = {UserAccountException.class})
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            readOnly = false,
            timeout = 6)
    public void purchase(String username, String isbn) {
        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        
        // 1. 获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        // 2. 更新书的库存
        bookShopDao.updateBookStock(isbn);

        // 3. 更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }
}
