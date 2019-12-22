package com.xt.spring.bean.spel;

import lombok.Data;

@Data
public class Person {

    private String name;
    private Car car;

    // 引用 address bean 的 city 属性
    private String city;

    // car.price >= 300000 ? 金领 : 白领
    private String info;

}
