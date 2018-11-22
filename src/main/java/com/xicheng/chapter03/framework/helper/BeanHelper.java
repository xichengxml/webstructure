package com.xicheng.chapter03.framework.helper;

import com.xicheng.chapter03.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xichengxml
 * @date 2018/11/12
 * @description
 */
public class BeanHelper {

    private static Map<Class<?>, Object> beanMap = new HashMap<>();

    static {
        Set<Class<?>> classSet = ClassHelper.getClassSet();
        for (Class<?> cls : classSet) {
            Object instance = ReflectionUtil.getInstance(cls);
            beanMap.put(cls, instance);
        }
    }

    /**
     * 获取bean映射
     * @return
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }

    /**
     * 获取bean实例
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<?> cls) {
        if (!beanMap.containsKey(cls)) {
            throw new RuntimeException("can not find bean by class：" + cls);
        }
        return (T)beanMap.get(cls);
    }

    /**
     * 设置bean实例
     * @param cls
     * @param obj
     */
    public static void setBean(Class<?> cls, Object obj) {
        beanMap.put(cls, obj);
    }
}
