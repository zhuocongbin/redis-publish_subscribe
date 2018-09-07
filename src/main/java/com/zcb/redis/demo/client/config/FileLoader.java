package com.zcb.redis.demo.client.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zhuocongbin
 * date 2018/9/7
 */
public class FileLoader {
    private static Properties properties;
    static {
        InputStream inputStream = FileLoader.class.getClassLoader()
                .getResourceAsStream("application.properties");
        try {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("file load error");
        }
    }
    private FileLoader(){}
    public static Properties getProperties() {
        return properties;
    }
}
