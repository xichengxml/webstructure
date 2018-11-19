package com.xicheng.chapter04_1.proxy.springaop;

import com.xicheng.chapter04_1.proxy.common.Apology;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 引入增强
 */
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        return super.invoke(invocation);
    }

    @Override
    public void saySorry(String name) {
        System.out.println("Sorry, " + name);
    }
}
