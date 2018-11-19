package com.xicheng.chapter04.proxy.staticp;

import com.xicheng.chapter04.proxy.common.Hello;
import com.xicheng.chapter04.proxy.common.HelloImpl;

public class HelloProxy implements Hello {

    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    @Override
    public void sayHello() {
        before();
        hello.sayHello();
        after();
    }

    private void before() {
        System.out.println("say before");
    }

    private void after() {
        System.out.println("say after");
    }
}
