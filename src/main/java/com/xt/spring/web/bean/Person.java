package com.xt.spring.web.bean;

import lombok.Data;

@Data
public class Person {

    private String username;

    public void hello() {
        System.out.println("My name is " + username);
    }
}
