package com.xicheng.chapter04.proxy.common;

import com.xicheng.chapter04.proxy.common.Hello;

public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("say something");
    }
}
