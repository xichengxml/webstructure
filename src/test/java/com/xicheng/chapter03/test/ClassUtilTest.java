package com.xicheng.chapter03.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author xichengxml
 * @date 2018/11/12
 * @description
 */
public class ClassUtilTest {

    private ClassLoader classLoader;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtilTest.class);
    @Before
    public void init() {
        classLoader = Thread.currentThread().getContextClassLoader();
    }
    @Test
    public void getClassSetTest() {
        try {
            Enumeration<URL> resources = classLoader.getResources("com.xicheng".replace(".", "/"));
            while (resources.hasMoreElements()) {
                LOGGER.error(resources.nextElement().toString());
            }
        } catch (IOException e) {
            LOGGER.error("something went wrong, pls check your code");
        }

    }
}
