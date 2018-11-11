package com.xicheng.chapter02.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 */
public class StringUtil {
    
    /**
    * @Description 判断字符串是否为空
    * @Date 2018/11/11
    * @Author xichengxml
    * @param 
    * @return 
    */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
    * @Description 判断字符串是否为空
    * @Date 2018/11/11
    * @Author xichengxml
    * @param 
    * @return 
    */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
