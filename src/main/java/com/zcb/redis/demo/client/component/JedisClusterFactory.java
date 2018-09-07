package com.zcb.redis.demo.client.component;

import com.zcb.redis.demo.client.config.FileLoader;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;

/**
 * Created by zhuocongbin
 * date 2018/9/7
 */
public class JedisClusterFactory {
    private static JedisCluster jedisCluster;
    static {
        Properties properties = FileLoader.getProperties();
        String hosts = properties.getProperty("redis.host");
        String password = properties.getProperty("redis.password");
        Integer cTimeout = Integer.valueOf(properties.getProperty("redis.connection.timeout"));
        String[] split = hosts.split(",");
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        List<String> list = Arrays.asList(split);
        JedisPoolConfig jedisPoolConfig = JedisPoolConfigLoader.getJedisPoolConfig();
        list.forEach(post -> {
            String[] split1 = post.split(":");
            HostAndPort hostAndPort = new HostAndPort(split1[0], Integer.valueOf(split1[1]));
            hostAndPorts.add(hostAndPort);
        });
        jedisCluster = new JedisCluster(hostAndPorts, cTimeout, 3000, 5, password, jedisPoolConfig);
    }
    private JedisClusterFactory(){}
    public static JedisCluster getJedisCluster() {
        return jedisCluster;
    }
}
