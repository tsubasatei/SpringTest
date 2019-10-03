package com.xt.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Component
@Aspect
public class ValidationAspect {

    @Before("execution(* com.xt.spring.aop.impl.ArithmeticCalculator.*(..))")
    public void validationArgs(JoinPoint joinPoint) {
        System.out.println("validate : " + Arrays.asList(joinPoint.getArgs()));
    }
}
