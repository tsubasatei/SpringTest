package com.xt.spring.tx;


public class BookStockException extends RuntimeException{
    public BookStockException(String message) {
        super(message);
    }
}
