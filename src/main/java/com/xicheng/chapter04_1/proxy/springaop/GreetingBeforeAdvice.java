package com.xicheng.chapter04_1.proxy.springaop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Spring AOP before advice");
    }
}
