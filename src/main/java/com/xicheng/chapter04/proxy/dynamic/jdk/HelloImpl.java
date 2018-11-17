package com.xicheng.chapter04.proxy.dynamic.jdk;

public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("jdk dynamic proxy");
    }
}
