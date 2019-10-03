package com.xt.spring.aop.helloworld;

public class MainTest {
    public static void main(String[] args) {
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        int result = proxy.add(1, 2);
        System.out.println("--> " + result);
    }
}
