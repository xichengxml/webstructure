package com.xicheng.chapter04_2.aspect;

import com.xicheng.chapter03.framework.annotation.Controller;
import com.xicheng.chapter03.framework.annotation.Aspect;
import com.xicheng.chapter03.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 拦截所有controller方法
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("---------------begin---------------");
        LOGGER.debug("class:{}", cls.getName());
        LOGGER.debug("method:{}", method.getName());
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("time:{}", System.currentTimeMillis() - begin);
        LOGGER.debug("-------------end----------------");
    }
}
