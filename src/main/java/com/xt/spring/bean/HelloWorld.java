package com.xt.spring.bean;


public class HelloWorld {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName: " + name);
        this.name = name;
    }

    public HelloWorld() {
        System.out.println("HelloWorld's Constructor");
    }

    public void hello() {
        System.out.println("Hello " + name);
    }

}
