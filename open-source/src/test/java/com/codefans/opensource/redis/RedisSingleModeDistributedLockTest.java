package com.codefans.opensource.redis;

import com.codefans.basicjava.concurrent.cas.CasLock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import sun.misc.BASE64Encoder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: codefans
 * @date: 2019-06-17 18:31:08
 */
public class RedisSingleModeDistributedLockTest {

    private RedisSingleModeDistributedLock redisSingleModeDistributedLock;

    private int threadNum = 10;
    private List<JedisSingleClient> jedisSingleClientList;
    private JedisSingleClient jedisSingleClient;

    private JedisPool jedisPool;

    @Before
    public void before() {

        jedisSingleClientList = new ArrayList<JedisSingleClient>(threadNum);
        String redisHost = "127.0.0.1";
        int port = 6379;
        String password = "redisPass123";
        jedisSingleClient = new JedisSingleClient(redisHost, port);
        jedisSingleClient.setAuth(password);

        for(int i = 0; i < threadNum; i ++) {
            redisHost = "127.0.0.1";
            port = 6379;
            password = "redisPass123";
            JedisSingleClient jedisClient = new JedisSingleClient(redisHost, port);
            jedisClient.setAuth(password);
//            System.out.println("jedisSingleClient=" + jedisSingleClient);
            jedisSingleClientList.add(jedisClient);
        }


    }

    /**
     * 多线程环境下要有多个jedis对象，多个到redis的连接。同一个jedis不能被多个线程共享，否则会报错。
     * 运行单元测试，结果是同时有多个线程get lock获得锁。
     */
    @Test
    public void getLockWithExpireTimeTest() {

        final String key = "getLockWithExpireTime";
        final int expiredTime = 10;

        int threadNum = 10;
        for(int i = 0; i < threadNum; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    JedisSingleClient jedisSingleClient = jedisSingleClientList.get(index);
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

    @Test
    public void getLockWithNXEXTest() {

        final String key = "getLockWithNXEX";
        final int expiredTime = 10;

        int threadNum = 10;

        for(int i = 0; i < threadNum; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {

//                    JedisSingleClient jedisSingleClient = jedisSingleClientList.get(index);
                    redisSingleModeDistributedLock = new RedisSingleModeDistributedLock(jedisSingleClient);

                    String currentThreadName = Thread.currentThread().getName();
                    String value = new BASE64Encoder().encode(currentThreadName.getBytes());
                    System.out.println("value=" + value);
                    boolean getLockSuccess = redisSingleModeDistributedLock.getLockWithNXEX(key, value, expiredTime);
                    System.out.println("thread[" + currentThreadName + "] " + (getLockSuccess ? "get lock!" : "miss lock!"));
                }
            }, "threadName_" + (i+1)).start();

        }

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    ReentrantLock reentrantLock = new ReentrantLock();
    CasLock casLock = new CasLock();
    volatile Object lock = new Object();
    int data = 1;

    @Test
    public void getLockWithNXEXLockTest() {
        final String key = "getLockWithNXEXLock";
        final int expiredTime = 10;
        String value = "getLockWithNXEXLock_value";
        String nxxx = "NX";
        String expx = "EX";

//        boolean setWithNXAndEXExpiredTime = jedisSingleClient.set(key, value, nxxx, expx, expiredTime);
//        System.out.println("setWithNXAndEXExpiredTime=" + setWithNXAndEXExpiredTime);

        int threadNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        redisSingleModeDistributedLock = new RedisSingleModeDistributedLock(jedisSingleClient);


        for(int i = 0; i < threadNum; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    String currentThreadName = Thread.currentThread().getName();
                    String value = new BASE64Encoder().encode(currentThreadName.getBytes());
//                    System.out.println("value=" + value);

                        try {
//                            reentrantLock.lock();
//                            casLock.lock();
//                            System.out.println("threadName:" + Thread.currentThread().getName() + ", index=" + index);
                            try {
//                                System.out.println("data=" + data++);
                                boolean getLockSuccess = redisSingleModeDistributedLock.getLockWithNXEXLock(key, value, expiredTime);
//                                boolean getLockSuccess = true;
                                if (getLockSuccess) {
                                    System.out.println("thread[" + currentThreadName + "] " + (getLockSuccess ? "get lock!" : "miss lock!"));
                                } else {
                                    System.out.println("getLockSuccess=" + getLockSuccess);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                redisSingleModeDistributedLock.releaseLockUsingEvalLuaConcurrency(key, value);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
//                            reentrantLock.unlock();
//                            casLock.unlock();
                        }
                    countDownLatch.countDown();
                }
            }, "threadName_" + (i+1)).start();

        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


    @Test
    public void getLockWithNXEXAndJedisPool() {

        String redisHost = "127.0.0.1";
        int redisPort = 6379;
        int timeout = 50000;
        String password = "redisPass123";
//        GenericObjectPoolConfig objectPoolConfig = new GenericObjectPoolConfig();
//        objectPoolConfig.setMaxTotal(10);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxIdle(30);
//        jedisPool = new JedisPool(jedisPoolConfig, redisHost, redisPort, timeout, password);
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, timeout, password);

        final String key = "getLockWithNXEX";
        final int expiredTime = 10;

        int threadNum = 10;
        BASE64Encoder base64Encoder = new BASE64Encoder();

        for(int i = 0; i < threadNum; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Jedis jedis = null;
                    try {
                        jedis = jedisPool.getResource();
                        JedisSingleClient jedisSingleClient = new JedisSingleClient(jedis);
                        redisSingleModeDistributedLock = new RedisSingleModeDistributedLock(jedisSingleClient);

                        String currentThreadName = Thread.currentThread().getName();
//                        String value = base64Encoder.encode(currentThreadName.getBytes());
                        String value = currentThreadName;
                        System.out.println("value=" + value);
                        boolean getLockSuccess = redisSingleModeDistributedLock.getLockWithNXEX(key, value, expiredTime);
                        System.out.println("thread[" + currentThreadName + "] " + (getLockSuccess ? "get lock!" : "miss lock!"));
                    } catch (Exception e) {
                        System.out.println("dfdfdfd");
                        e.printStackTrace();
                    }
                    finally {
                        jedis.close();
                    }
                }
            }, "threadName_" + (i+1)).start();

        }

        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @After
    public void after() {

        if(jedisPool != null) {
            jedisPool.destroy();
            System.out.println("jedis连接池关闭");
        }

    }

}
