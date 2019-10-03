package com.xt.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {

    // 要代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;

        // 代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        // 代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        // 当调用代理对象其中的方法，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy : 正在返回的那个代理对象，一般情况下，在 invoke 方法中都不使用该对象
             * @param method : 正在被调用的方法
             * @param args : 调用方法时。传入的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                // 日志开始
                System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
                Object result = null;

                try {
                    // 前置通知
                    result = method.invoke(target, args);
                    // 返回通知，可以访问到方法的返回值
                }  catch (Exception e) {
                    e.printStackTrace();
                    // 异常通知，可以访问到方法出现的异常
                }

                // 后置通知，因为方法可能会出现异常，所以访问不到方法的返回值

                // 日志结束
                System.out.println("The method " + methodName + " end with " + result);
                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
        return proxy;
    }
}
