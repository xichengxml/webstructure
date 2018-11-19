package com.xicheng.chapter04_1.proxy.common;

public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("say something");
    }
}
