package com.xicheng.chapter04.proxy.staticp;

public class HelloMain {

    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxy();
        helloProxy.sayHello();
    }
}
