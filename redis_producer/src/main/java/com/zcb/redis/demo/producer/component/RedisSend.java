package com.zcb.redis.demo.producer.component;

import com.zcb.redis.demo.client.component.JedisClusterFactory;
import redis.clients.jedis.JedisCluster;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhuocongbin
 * date 2018/9/7
 */
public class RedisSend {
    private static JedisCluster jedisCluster;
    static {
        jedisCluster = JedisClusterFactory.getJedisCluster();
    }
    public void send() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(2);
            jedisCluster.publish("name", "zhangsan" + i);
        }
    }
}
