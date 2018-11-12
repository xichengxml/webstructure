package com.xicheng.chapter03.framework.helper;

import com.xicheng.chapter02.util.CollectionUtil;
import com.xicheng.chapter03.framework.annotation.Inject;
import com.xicheng.chapter03.framework.util.ReflectionUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author xichengxml
 * @date 2018/11/12
 * @description
 */
public class IocHelper {

    /**
     * 获取所有的bean映射关系，遍历取出bean实例，获取bean中的所有属性，找出带有inject注解的属性
     * 从map中取出实例注入
     */
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> entry : beanMap.entrySet()) {
                Class<?> cls = entry.getKey();
                Object instance = entry.getValue();
                Field[] fields = cls.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(fields)) {
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(Inject.class)) {
                            Class<?> beanClassName = field.getType();
                            Object beanFiledInstance = beanMap.get(beanClassName);
                            if (beanFiledInstance != null) {
                                ReflectionUtil.setField(instance, field, beanFiledInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
