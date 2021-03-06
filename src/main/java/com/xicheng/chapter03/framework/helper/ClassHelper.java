package com.xicheng.chapter03.framework.helper;

import com.xicheng.chapter03.framework.annotation.Controller;
import com.xicheng.chapter03.framework.annotation.Service;
import com.xicheng.chapter03.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xichengxml
 * @date 2018/11/12
 * @description 类操作助手类
 */
public class ClassHelper {

    private static Set<Class<?>> classSet;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        classSet = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return classSet;
    }

    /**
     * 获取应用名下所有service类
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> serviceClassSet = new HashSet<>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(Service.class)) {
                serviceClassSet.add(cls);
            }
        }
        return serviceClassSet;
    }

    /**
     * 获取应用名下的所有controller类
     * @return
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> controllerClassSet = new HashSet<>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(Controller.class)) {
                controllerClassSet.add(cls);
            }
        }
        return controllerClassSet;
    }

    /**
     * 获取应用包下的所有bean类，包含service和controller
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

    /**
    * @Description 获取应用包名下某父类（接口）的所有子类（或实现类）
    * @Date 2018/11/22
    * @Author xichengxml
    * @param
    * @return
    */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> clsSet = new HashSet<>();
        for (Class<?> cls : classSet) {
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                clsSet.add(cls);
            }
        }
        return clsSet;
    }

    /**
    * @Description 获取应用包名下带有某注解的所有类
    * @Date 2018/11/23
    * @Author xichengxml
    * @param
    * @return
    */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> clsSet = new HashSet<>();
        for (Class<?> cls : classSet) {
            if (cls.isAnnotationPresent(annotationClass)) {
                clsSet.add(cls);
            }
        }
        return clsSet;
    }
}
