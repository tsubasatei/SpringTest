package com.xt.spring.tx;


import java.util.List;

public interface Cashier {

    void checkout(String username, List<String> isbns);
}
