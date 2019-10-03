package com.xt.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 把这个类声明为一个切面：需要把该类放入到 IOC 容器中，再声明为一个切面
 * 可以使用 @Order(2) 注解指定切面的优先级，值越小优先级越高
 */
@Order(2)
@Component
@Aspect
public class LoggingAspect {

    /**
     * 定义一个方法，用于声明切入点表达式。一般地，该方法中不再需要添加其他的代码
     * 使用 @Pointcut 来声明切入点表达式
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式
     */
    @Pointcut("execution(public int com.xt.spring.aop.impl.ArithmeticCalculatorImpl.*(..))")
    public void declareJoinPointExpression(){}

    /**
     * 声明该方法是一个前置通知：在目标方法开始之前执行
     */
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    /**
     * 后置通知：在目标方法执行后（无论是否发生异常），执行的通知
     * 在后置通知中还不能访问目标方法执行的结果
     * @param joinPoint
     */
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends ");
    }

    /**
     * 在方法正常结束后执行的代码
     * 返回通知是可以访问到方法的返回值
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "declareJoinPointExpression()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    /**
     * 在目标方法出现异常时会执行的代码
     * 可以访问到异常对象；且可以指定在出现特定异常时执行通知代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "declareJoinPointExpression()",
            throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception " + ex);
    }

    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知类似于动态代理的全过程 ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param pjp
     */
    /*
    @Around("execution(* com.xt.spring.aop.impl.ArithmeticCalculatorImpl.*(..))")
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
    */
}
