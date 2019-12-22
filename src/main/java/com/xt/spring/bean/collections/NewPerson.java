package com.xt.spring.bean.collections;

import com.xt.spring.bean.Car;
import lombok.Data;

import java.util.Map;

@Data
public class NewPerson {
    private String name;
    private int age;
    private Map<String, Car> cars;

}
