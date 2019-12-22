package com.xt.spring.bean.factorybean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String brand;
    private double price;

    public Car() {
        System.out.println("Car's Constructor....");
    }
}
