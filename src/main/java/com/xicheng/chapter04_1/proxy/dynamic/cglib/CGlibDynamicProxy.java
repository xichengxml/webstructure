package com.xicheng.chapter04_1.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibDynamicProxy implements MethodInterceptor{

    private static CGlibDynamicProxy instance = new CGlibDynamicProxy();

    public CGlibDynamicProxy() {
    }

    public static CGlibDynamicProxy getInstance() {
        return instance;
    }

    public <T> T getProxy(Class<T> cls) {
        return (T)Enhancer.create(cls, this);
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("say before");
    }

    private void after() {
        System.out.println("say after");
    }
}
