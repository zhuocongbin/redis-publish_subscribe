package com.zcb.redis.demo.client.component;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by zhuocongbin
 * date 2018/9/7
 */
public class JedisPoolConfigLoader {
    private static JedisPoolConfig jedisPoolConfig;
    static {
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxWaitMillis(3000);
        jedisPoolConfig.setTestOnBorrow(true);
    }
    private JedisPoolConfigLoader(){}
    public static JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }
}
