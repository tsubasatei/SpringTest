package com.xt.spring.tx.xml.service.impl;

import com.xt.spring.tx.xml.service.BookShopService;
import com.xt.spring.tx.xml.service.Cashier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Transactional
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
