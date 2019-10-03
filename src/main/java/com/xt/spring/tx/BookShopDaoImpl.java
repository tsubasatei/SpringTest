package com.xt.spring.tx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    public void updateBookStock(String isbn) {
        // 检查书的库存是否足够，若不够，则抛出异常
        String sql2 = "select stock from book_stock where isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (stock == 0) {
            throw new BookStockException("库存不足！");
        }
        String sql = "update book_stock set stock = stock -1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    public void updateUserAccount(String username, int price) {
        // 验证余额是否足够，若不足，则抛出异常
        String sql2 = "select balance from account where username = ?";
        int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
        if (balance < price) {
            throw new UserAccountException("余额不足！");
        }
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, price, username);
    }
}
