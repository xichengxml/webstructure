package com.xicheng.chapter04.proxy.dynamic.jdk;

public class HelloMain {

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        Hello proxy = dynamicProxy.getProxy();
        proxy.sayHello();
    }
}
