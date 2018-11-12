package com.xicheng.chapter03.framework.bean;

import java.lang.reflect.Method;

/**
 * @author xichengxml
 * @date 2018/11/12
 * @description 封装Action信息
 */
public class Handler {

    private Class<?> controllerClass;
    private Method actionMethod;

    public Handler() {
    }

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(Method actionMethod) {
        this.actionMethod = actionMethod;
    }
}
