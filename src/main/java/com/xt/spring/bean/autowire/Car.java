package com.xt.spring.bean.autowire;

import lombok.Data;

@Data
public class Car {
    private String brand;
    private double price;

    public Car() {
        System.out.println("Car's Constructor....");
    }

}
