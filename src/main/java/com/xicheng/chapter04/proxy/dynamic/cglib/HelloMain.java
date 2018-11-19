package com.xicheng.chapter04.proxy.dynamic.cglib;

import com.xicheng.chapter04.proxy.common.Hello;
import com.xicheng.chapter04.proxy.common.HelloImpl;

public class HelloMain {

    public static void main(String[] args) {

        Hello hello = CGlibDynamicProxy.getInstance().getProxy(HelloImpl.class);
        hello.sayHello();
    }
}
