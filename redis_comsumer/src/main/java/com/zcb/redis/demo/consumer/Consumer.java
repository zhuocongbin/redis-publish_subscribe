package com.zcb.redis.demo.consumer;

import com.zcb.redis.demo.consumer.component.ConsumerHandler;

/**
 * Created by zhuocongbin
 * date 2018/9/7
 */
public class Consumer {
    public static void main(String[] args) {
        ConsumerHandler handler = new ConsumerHandler();
        handler.consumer("name");
    }
}
