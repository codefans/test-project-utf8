package com.codefans.opensource.redis;

import org.junit.Before;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-06-17 18:31:08
 */
public class RedisSingleModeDistributedLockTest {

    private RedisSingleModeDistributedLock redisSingleModeDistributedLock;

    @Before
    public void before() {

        String redisHost = "127.0.0.1";
        int port = 6379;
        String password = "redisPass123";
        JedisSingleClient jedisSingleClient = new JedisSingleClient(redisHost, port, password);
        redisSingleModeDistributedLock = new RedisSingleModeDistributedLock(jedisSingleClient);


    }

    /**
     * 多线程环境下要有多个jedis对象，多个到redis的连接。同一个jedis不能被多个线程共享，否则会报错。
     * 运行单元测试，结果是同时有多个线程get lock获得锁。
     */
    @Test
    public void getLockWithExpireTimeTest() {

        String key = "getLockWithExpireTime";
        int expiredTime = 10;

        int threadNum = 10;
        for(int i = 0; i < threadNum; i ++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String redisHost = "127.0.0.1";
                    int port = 6379;
                    String password = "redisPass123";
                    JedisSingleClient jedisSingleClient = new JedisSingleClient(redisHost, port, password);
                    System.out.println("jedisSingleClient=" + jedisSingleClient);
                    redisSingleModeDistributedLock = new RedisSingleModeDistributedLock(jedisSingleClient);

                    boolean getLockSuccess = redisSingleModeDistributedLock.getLockWithExpireTime(key, expiredTime);
                    System.out.println("thread[" + Thread.currentThread().getName() + "] " + (getLockSuccess ? "get lock!" : "miss lock!"));
                }
            }, "threadName_" + (i+1)).start();

        }

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
