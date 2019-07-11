package com.codefans.opensource.redis.jedispool;

import com.codefans.opensource.redis.JedisClientBase;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: codefans
 * @date: 2019-06-18 01:24:52
 */
public class PooledJedisClient extends JedisClientBase {

    JedisPool jedisPool;

    private int timeout;

    public PooledJedisClient(String redisHost, int redisPort, int timeout, String password) {
        this.host = redisHost;
        this.port = redisPort;
        this.timeout = timeout;
        this.password = password;


        jedisPool = new JedisPool(new JedisPoolConfig(), this.host, this.port, timeout, this.password);
    }

    public PooledJedisClient(String redisAddr, String password) {

    }




}
