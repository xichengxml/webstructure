package com.xicheng.chapter02.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 */
public class CollectionUtil {

    /**
    * @Description 判断Collection是否为空
    * @Date 2018/11/11
    * @Author xichengxml
    * @param 
    * @return 
    */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

    /**
    * @Description 判断collection是否非空
    * @Date 2018/11/11
    * @Author xichengxml
    * @param 
    * @return 
    */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
    * @Description 判断map是否为空
    * @Date 2018/11/11
    * @Author xichengxml
    * @param 
    * @return 
    */
    public static boolean isEmpty(Map<?, ?> map) {
        return MapUtils.isEmpty(map);
    }

    /**
    * @Description 判断map是否非空
    * @Date 2018/11/11
    * @Author xichengxml
    * @param 
    * @return 
    */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
