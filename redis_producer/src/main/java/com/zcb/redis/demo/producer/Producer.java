package com.zcb.redis.demo.producer;

import com.zcb.redis.demo.producer.component.RedisSend;

/**
 * Created by zhuocongbin
 * date 2018/9/7
 */
public class Producer {
    public static void main(String[] args) {
        RedisSend send = new RedisSend();
        try {
            send.send();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
