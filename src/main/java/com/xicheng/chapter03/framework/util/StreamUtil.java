package com.xicheng.chapter03.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流操作工具类
 */
public class StreamUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流中获取字符串
     * @param is
     * @return
     */
    public static String getstring(InputStream is) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            String content;
            while ((content = bf.readLine()) != null) {
                stringBuilder.append(content);
            }
        } catch (IOException e) {
            LOGGER.error("get string failure");
        }
        return stringBuilder.toString();
    }

}
