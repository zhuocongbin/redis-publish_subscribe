package com.zcb.redis.demo.consumer.component;

import com.zcb.redis.demo.client.component.JedisClusterFactory;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by zhuocongbin
 * date 2018/9/7
 */
public class ConsumerHandler {
    private static JedisCluster jedisCluster;
    static {
        jedisCluster = JedisClusterFactory.getJedisCluster();
    }
    public void consumer(String name) {
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("Channel:"+channel);
                System.out.println("Message:"+message.toString());
            }

            @Override
            public void onPMessage(String pattern, String channel, String message) {
                System.out.println(pattern + "=" + channel + "=" + message);
            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                System.out.println("onSubscribe:"+channel);
            }

            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
                System.out.println("onUnsubscribe: " + channel);
            }
        };
        jedisCluster.subscribe(jedisPubSub, name);
    }
}
