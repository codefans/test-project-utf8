package com.codefans.opensource.redis.rediscli;

import org.junit.Test;

import java.io.IOException;

/**
 * @author: codefans
 * @date: 2019-07-12 10:06
 */
public class RedisCliTest {

    @Test
    public void redisCliTest() {

        RedisCli redisCli = new RedisCli();

        try {

            String exc = "/Development/redis-cluster/one-node-3790/redis-4.0.9/bin/redis-cli";
            String command = exc + " -h 127.0.0.1 -p 3793 -a redisPass123";
            redisCli.execute(command);

            command = "cluster slots";
            redisCli.write(command);
            /**
             * TODO 读取有问题
             */
            String response = redisCli.readLine();
            System.out.println("response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            redisCli.close();
        }


    }

}
