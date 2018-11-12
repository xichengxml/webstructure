package com.xicheng.chapter03.framework.common;

import com.xicheng.chapter03.framework.helper.BeanHelper;
import com.xicheng.chapter03.framework.helper.ClassHelper;
import com.xicheng.chapter03.framework.helper.ControllerHelper;
import com.xicheng.chapter03.framework.helper.IocHelper;
import com.xicheng.chapter03.framework.util.ClassUtil;

/**
 * 加载相应的helper类
 */
public class HelperLoader {

    public static void init() {
        Class<?>[] classArray = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classArray) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
