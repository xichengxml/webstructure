package com.xicheng.chapter04_1.proxy.springaop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("GreetingBeforeAndAfterAdvice before");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("GreetingBeforeAndAfterAdvice after");
    }
}
