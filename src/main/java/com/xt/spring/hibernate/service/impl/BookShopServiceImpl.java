package com.xt.spring.hibernate.service.impl;

import com.xt.spring.hibernate.dao.BookShopDao;
import com.xt.spring.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookShopServiceImpl implements BookShopService {

    /**
     * Spring hibernate 事务的流程
     *
     * 1. 在方法开始之前
     *      ①. 获取 Session
     *      ②. 把 Session 和当前线程绑定，这样就可以在 Dao 中使用 SessionFactory 的
     *          getCurrentSession() 方法来获取 Session
     *      ③. 开启事务
     *
     * 2. 若方法正常结束，即没有出现异常，则
     *      ①. 提交事务
     *      ②. 使当前线程绑定的 Session 解除绑定
     *      ③. 关闭 Session
     *
     * 3. 若方法出现异常，则
     *      ①. 回滚事务
     *      ②. 使当前线程绑定的 Session 解除绑定
     *      ③. 关闭 Session
     */
    @Autowired
    private BookShopDao bookShopDao;

    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username, price);
    }
}
