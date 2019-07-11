package com.codefans.opensource.redis.jedispool;

import com.codefans.opensource.redis.sharding.RW;
import com.codefans.opensource.redis.sharding.TaskCallback;
import redis.clients.jedis.JedisPool;

/**
 * @author: codefans
 * @date: 2019-07-11 10:32
 */
public class PooledJedisTemplate {

    private JedisPool jedisPool;

    public <R> R execute(String key, TaskCallback<R> task, RW rw) {
        R result = null;

        return result;
    }
}
