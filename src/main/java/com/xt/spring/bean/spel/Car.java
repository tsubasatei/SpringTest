package com.xt.spring.bean.spel;

import lombok.Data;

@Data
public class Car {
    private String brand;
    private double price;

    // 轮胎周长
    private double typePerimeter;

    public Car() {
        System.out.println("Car's Constructor....");
    }

}
