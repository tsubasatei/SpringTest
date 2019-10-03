package com.xt.spring.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义 FactoryBean 需要实现 FactoryBean 接口
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // 返回 bean 的对象
    public Car getObject() throws Exception {
        return new Car("BMW", 500000);
    }

    // 返回 bean 的类型
    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
