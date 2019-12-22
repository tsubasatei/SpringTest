package com.xt.spring.bean.cycle;

import lombok.ToString;

@ToString
public class Car {

    private String brand;

    public Car() {
        System.out.println("Car's Constructor...");
    }

    public void setBrand(String brand) {
        System.out.println("setBrand");
        this.brand = brand;
    }

    public void init() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}
