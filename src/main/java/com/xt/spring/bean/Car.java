package com.xt.spring.bean;

import lombok.Data;

@Data
public class Car {

    private String brand;
    private String corp;
    private int price;
    private double maxSpeed;

    public Car(String brand, String corp, int price) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public Car(String brand, String corp, double maxSpeed) {
        this.brand = brand;
        this.corp = corp;
        this.maxSpeed = maxSpeed;
    }

}
