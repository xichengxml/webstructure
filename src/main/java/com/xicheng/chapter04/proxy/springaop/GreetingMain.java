package com.xicheng.chapter04.proxy.springaop;

import com.xicheng.chapter04.proxy.common.Hello;
import com.xicheng.chapter04.proxy.common.HelloImpl;
import org.springframework.aop.framework.ProxyFactory;

public class GreetingMain {

    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    /**
     * 测试前置通知和后置通知
     */
    private static void test01() {
        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 射入目标对象
        proxyFactory.setTarget(new HelloImpl());
        // 添加前置增强
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        // 添加后置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());

        // 获取代理对象
        Hello hello = (Hello) proxyFactory.getProxy();
        // 调用代理的方法
        hello.sayHello();
    }

    /**
     * 前置和后置通知放在同一个类
     */
    private static void test02() {
        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 射入目标对象
        proxyFactory.setTarget(new HelloImpl());
        // 添加通知
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        // 获取代理对象
        Hello hello = (Hello) proxyFactory.getProxy();
        // 调用代理的方法
        hello.sayHello();
    }

    /**
     * 环绕通知
     */
    private static void test03() {
        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 射入目标对象
        proxyFactory.setTarget(new HelloImpl());
        /// 添加通知
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        // 获取代理对象
        Hello hello = (Hello) proxyFactory.getProxy();
        // 调用代理的方法
        hello.sayHello();
    }
}
