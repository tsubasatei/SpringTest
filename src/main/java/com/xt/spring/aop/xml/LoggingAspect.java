package com.xt.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;
import java.util.List;

public class LoggingAspect {

    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends ");
    }

    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception " + ex);
    }

    public Object around(ProceedingJoinPoint pjp) {
        Object result = null;
        String methodName = pjp.getSignature().getName();

        try {
            // 前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjp.getArgs()));
            // 执行目标方法
            result = pjp.proceed();
            // 返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable ex) {
            System.out.println("The method " + methodName + " occurs exception " + ex);
            throw new RuntimeException(ex);
        }
        // 后置通知
        System.out.println("The method " + methodName + " ends ");
        return result;
    }
}
