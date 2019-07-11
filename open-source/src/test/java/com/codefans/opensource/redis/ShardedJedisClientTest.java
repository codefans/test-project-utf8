package com.codefans.opensource.redis;

import com.codefans.basicjava.concurrent.threadpool.DefaultThreadPool;
import com.codefans.opensource.redis.sharding.EXPX;
import com.codefans.opensource.redis.sharding.NXXX;
import com.codefans.opensource.redis.sharding.ShardedJedisClient;
import com.codefans.opensource.redis.sharding.ShardedJedisTemplate;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: codefans
 * @date: 2019-07-11 10:44
 */
public class ShardedJedisClientTest {

    private ShardedJedisClient shardedJedisClient;

    @Before
    public void before() {
        String redisHost = "127.0.0.1";
        int port = 6379;
        String password = "redisPass123";
        int timeout = 60;

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(1000);
        poolConfig.setMaxIdle(990);
        poolConfig.setMinIdle(10);
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setMaxWaitMillis(60000);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        JedisPool jedisPool = new JedisPool(poolConfig, redisHost, port, timeout, password);

        ShardedJedisTemplate shardedJedisTemplate = new ShardedJedisTemplate(jedisPool);
        shardedJedisClient = new ShardedJedisClient(shardedJedisTemplate);

    }

    @Test
    public void setTest() {

        String key = "shardedJedisClientKey";
        String value = "shardedJedisClientKey_value";
        int timeout = 60;

        int threadNums = 50;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                boolean isSuccess = shardedJedisClient.set(key, value, NXXX.NX, EXPX.EX, timeout);
                System.out.println("isSuccess=" + isSuccess);
            }
        };

        DefaultThreadPool defaultThreadPool = new DefaultThreadPool();
        defaultThreadPool.submit(threadNums, task);

    }

}
