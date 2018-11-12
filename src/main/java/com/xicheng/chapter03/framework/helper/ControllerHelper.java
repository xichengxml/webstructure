package com.xicheng.chapter03.framework.helper;

import com.xicheng.chapter02.util.CollectionUtil;
import com.xicheng.chapter03.framework.annotation.Action;
import com.xicheng.chapter03.framework.bean.Handler;
import com.xicheng.chapter03.framework.bean.Request;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 */
public class ControllerHelper {

    /**
     * 用于存放请求和处理器的映射关系
     */
    private static Map<Request, Handler> actionMap = new HashMap<>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> cls : controllerClassSet) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                if (ArrayUtils.isNotEmpty(declaredMethods)) {
                    for (Method method : declaredMethods) {
                        if (method.isAnnotationPresent(Action.class)) {
                            Action annotation = method.getAnnotation(Action.class);
                            String mapping = annotation.value();
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(cls, method);
                                    actionMap.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取handler
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return actionMap.get(request);
    }
}
