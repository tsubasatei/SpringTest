package com.xt.spring.bean.collections;

import com.xt.spring.bean.Car;
import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String name;
    private int age;
    private List<Car> cars;

}
