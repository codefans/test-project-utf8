package com.codefans.opensource.redis;

import com.codefans.basicjava.concurrent.threadpool.DefaultThreadPool;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: codefans
 * @date: 2018-05-06 16:41
 */
public class JedisClusterTest extends JedisClientBase {

    JedisCluster jedisCluster;
    
    @Before
    public void before() {
        this.initLocalEnv();
//        this.initDevEnv();
//        this.initTestEnv();
    }

    public void initLocalEnv() {
        host = "127.0.0.1";
        port = 3793;
        password = "redisPass123";
        connectionTimeout = 10000;
        soTimeout = 10000;

//        jedis = new Jedis(host, port, connectionTimeout, soTimeout);
//        jedis.auth(password);

        maxAttempts = 3;
        poolConfig = new JedisPoolConfig();
        //最小空闲连接数
        poolConfig.setMinIdle(minIdle);
        //最大空闲连接数
        poolConfig.setMaxIdle(maxIdle);
        //最大连接数
        poolConfig.setMaxTotal(maxTotal);


        HostAndPort hostAndPort = new HostAndPort(host, port);
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        hostAndPortSet.add(hostAndPort);
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3794));
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3795));
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3796));
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3797));
//        hostAndPortSet.add(new HostAndPort("127.0.0.1", 3798));

        jedisCluster = new JedisCluster(hostAndPortSet, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);

        System.out.println("cluster.size():" + jedisCluster.getClusterNodes().size());

    }

    public void initDevEnv() {
        host = "10.60.58.139";
        port = 6379;
        password = "Lsjrxd";
        connectionTimeout = 10000;
        soTimeout = 10000;

//        jedis = new Jedis(host, port, connectionTimeout, soTimeout);
//        jedis.auth(password);

        maxAttempts = 3;
        poolConfig = new JedisPoolConfig();
        //最小空闲连接数
        poolConfig.setMinIdle(minIdle);
        //最大空闲连接数
        poolConfig.setMaxIdle(maxIdle);
        //最大连接数
        poolConfig.setMaxTotal(maxTotal);


        HostAndPort hostAndPort = new HostAndPort(host, port);
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
//        hostAndPortSet.add(hostAndPort);
        hostAndPortSet.add(new HostAndPort(host, 6000));
        hostAndPortSet.add(new HostAndPort(host, 6001));

        jedisCluster = new JedisCluster(hostAndPortSet, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);

        System.out.println("cluster.size():" + jedisCluster.getClusterNodes().size());

    }

    public void initTestEnv() {

        maxAttempts = 3;
        poolConfig = new JedisPoolConfig();
        //最小空闲连接数
        poolConfig.setMinIdle(minIdle);
        //最大空闲连接数
        poolConfig.setMaxIdle(maxIdle);
        //最大连接数
        poolConfig.setMaxTotal(maxTotal);


        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        hostAndPortSet.add(new HostAndPort("10.60.54.227", 6479));
        hostAndPortSet.add(new HostAndPort("10.60.54.229", 6379));

        jedisCluster = new JedisCluster(hostAndPortSet, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);

        System.out.println("cluster.size():" + jedisCluster.getClusterNodes().size());

    }


    @Test
    public void setGetTest() {

        String key = "key0001";
        String value = "value0001";

        jedisCluster.set(key, value);

        value = jedisCluster.get(key);
        System.out.println("value:" + value);


    }

    @Test
    public void jedisClusterInMultiThreadEnvTest() {

        final String key = "jedisClusterSetTestKey";
        final String value = "jedisClusterSetTestKey_value";
        final String nxxx = "NX";
        final String expx = "EX";
        final int timeout = 60;

        int threadNums = 10;

//        ReentrantLock lock = new ReentrantLock();

        DefaultThreadPool defaultThreadPool = new DefaultThreadPool();
        Runnable task = new Runnable() {
            @Override
            public void run() {
//                lock.lock();
//                try {
                String newKey = key + System.currentTimeMillis();
                    String result = jedisCluster.set(newKey, value, nxxx, expx, timeout);
                    System.out.println("key=" + newKey + ", result=" + result + ", redisAddr=" + RedisContext.getAddr());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
            }
        };

//        for(int i = 0; i < threadNums; i ++) {
//            defaultThreadPool.execute(task);
//        }

        defaultThreadPool.submit(threadNums, task);


    }

}
