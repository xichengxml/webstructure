package com.xicheng.chapter02.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 转型操作工具类
 */
public class CastUtil {

    /**
     * 转为String型
     * @param obj
     * @return
     */
    public static String castString(Object obj) {
        return castString(obj, "");
    }

    /**
     * 转为String型，提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转为double类型
     * @param obj
     * @return
     */
    public static double castDouble(Object obj) {
        return castDouble(obj, 0);
    }

    /**
     * 转为double类型，提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转为long类型
     * @param obj
     * @return
     */
    public static long castLong(Object obj) {
        return castLong(obj, 0);
    }

    /**
     * 转为long类型，提供默认值
     * @param obj
     * @param defaultValue
     * @return
     */
    public static long castLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
    * @Description 转为boolean类型，默认false
    * @Date 2018/11/11
    * @Author xichengxml
    * @param obj
    * @return 
    */
    public static boolean castBoolean(Object obj) {
        return castBoolean(obj, false);
    }

    /**
    * @Description 转为boolean类型，提供默认值
    * @Date 2018/11/11
    * @Author xichengxml
    * @param 
    * @return 
    */
    public static boolean castBoolean(Object obj, boolean defaulValue) {
        boolean booleanValue = defaulValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    booleanValue = Boolean.parseBoolean(strValue);
                } catch (Exception e) {
                    booleanValue = defaulValue;
                }
            }
        }
        return booleanValue;
    }
    
    /**
    * @Description 转为int类型，默认0
    * @Date 2018/11/11
    * @Author xichengxml
    * @param 
    * @return 
    */
    public static int castInt(Object obj) {
        return castInt(obj, 0);
    }

    /**
    * @Description 转为int类型，提供默认值
    * @Date 2018/11/11
    * @Author xichengxml
    * @param
    * @return
    */
    public static int castInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }
}
