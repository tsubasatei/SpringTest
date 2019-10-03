package com.xt.spring.hibernate.dao.impl;

import com.xt.spring.hibernate.dao.BookShopDao;
import com.xt.spring.hibernate.exception.BookStockException;
import com.xt.spring.hibernate.exception.UserAccountException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private SessionFactory sessionFactory;

    // 获取和当前线程绑定的 Session
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 不推荐使用 HibernateTemplate 和 HibernateDaoSupport
     * 因为这样会导致 Dao 和 Spring 的 API 进行耦合，可移植性变差
     *
     */
    //private HibernateTemplate hibernateTemplate;

    public int findBookPriceByIsbn(String isbn) {
        String hql = "select b.price from Book b where b.isbn = ?1";
        Query query = getSession().createQuery(hql).setParameter(1, isbn);
        return (Integer) query.uniqueResult();
    }

    public void updateBookStock(String isbn) {
        // 验证书的库存是否充足
        String hql = "select b.stock from Book b where b.isbn = ?1";
        int stock = (Integer) getSession().createQuery(hql).setParameter(1, isbn).uniqueResult();
        if (stock == 0) {
            throw new BookStockException("库存不足！");
        }
        String hql2 = "update Book b set b.stock = b.stock - 1 where isbn = ?1";
        getSession().createQuery(hql2).setParameter(1, isbn).executeUpdate();
    }

    public void updateUserAccount(String username, int price) {
        // 验证账户余额是否充足
        String hql = "select a.balance from Account a where a.username = ?1";
        int balance = (Integer) getSession().createQuery(hql).setParameter(1, username).uniqueResult();
        if (balance < price) {
            throw new UserAccountException("余额不足！");
        }
        String hql2 = "update Account a set a.balance = a.balance - ?1 where a.username = ?2";
        getSession().createQuery(hql2).setParameter(1, price).setParameter(2, username).executeUpdate();
    }
}
