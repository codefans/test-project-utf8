package com.codefans.opensource.redis.sharding;

import redis.clients.jedis.Jedis;

/**
 * @author: codefans
 * @date: 2019-07-11 09:19
 * 分片模式-客户端
 */
public class ShardedJedisClient {

    private ShardedJedisTemplate shardedJedisTemplate;

    public ShardedJedisClient(ShardedJedisTemplate shardedJedisTemplate) {
        this.shardedJedisTemplate = shardedJedisTemplate;
    }

    /**
     *
     * @param key
     * @param value
     * @param nxxx
     * @param expx
     * @param expires
     * @return
     */
    public boolean set(String key, String value, String nxxx, String expx, long expires) {
        return shardedJedisTemplate.execute(key, new TaskCallback<Boolean>() {
            @Override
            public Boolean call(Jedis jedis) {
                return "OK".equals(jedis.set(key, value, nxxx, expx, expires));
            }
        }, RW.READ);
    }




}
