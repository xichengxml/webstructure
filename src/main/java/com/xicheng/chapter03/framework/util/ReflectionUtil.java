package com.xicheng.chapter03.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xichengxml
 * @date 2018/11/12
 * @description 反射工具类
 */
public class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     * @param cls
     * @return
     */
    public static Object getInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("create new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 方法调用
     * @param obj
     * @param method
     * @param params
     * @return
     */
    public static Object invokeMethod(Object obj, Method method, Object... params) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, params);
        } catch (Exception e) {
            LOGGER.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param obj
     * @param field
     * @param value
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            LOGGER.error("set field value failure", e);
            throw new RuntimeException(e);
        }
    }
}
