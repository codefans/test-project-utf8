package com.codefans.opensource.redis;

import com.codefans.opensource.redis.springdata.SpringDataRedisDistributedLock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

/**
 * @author: codefans
 * @date: 2019-07-09 10:10
 */
public class SpringDataRedisTest {

    private JedisConnectionFactory jedisConnectionFactory;
    private StringRedisTemplate stringRedisTemplate;

    @Before
    public void before() {
        String redisHost = "127.0.0.1";
        int redisPort = 6379;
        String redisPass = "redisPass123";
        JedisShardInfo jedisShardInfo = new JedisShardInfo(redisHost, redisPort);
        jedisShardInfo.setPassword(redisPass);
        jedisConnectionFactory = new JedisConnectionFactory(new JedisPoolConfig());
        jedisConnectionFactory.setShardInfo(jedisShardInfo);
        stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        stringRedisTemplate.afterPropertiesSet();
    }


    @Test
    public void helloWorld() {

        String key = "hello";
//        RedisClusterConnection redisConn = jedisConnectionFactory.getClusterConnection();
//        redisConn.set(key.getBytes(), "world".getBytes());
//
//        byte[] result = redisConn.get(key.getBytes());
//        System.out.println(new String(result));

        int threadNums = 10;
        for(int i = 0; i < threadNums; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    stringRedisTemplate.opsForSet().add(key + "_" + index, "world");
                    System.out.println("key:[" + (key + "_" + index) + "], value:[" + stringRedisTemplate.opsForSet().pop(key + "_" + index) + "]");
                }
            }).start();

        }

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void distributedLockTest() {

        String lockKey = "letvUserIdKey";
        SpringDataRedisDistributedLock springDataRedisLock = new SpringDataRedisDistributedLock(stringRedisTemplate, lockKey);

        int threadNums = 10;
        for(int i = 0; i < threadNums; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                        if(springDataRedisLock.lock()) {
                            System.out.println("index=" + index);
                        } else {
                            System.out.println("lock return false;");
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        springDataRedisLock.unlock();
                    }

                }
            }).start();

        }

        try {
            Thread.sleep(100 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }





}
