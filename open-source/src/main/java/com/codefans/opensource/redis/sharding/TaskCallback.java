package com.codefans.opensource.redis.sharding;

import redis.clients.jedis.Jedis;

/**
 * @author: codefans
 * @date: 2019-07-11 09:31
 */
public interface TaskCallback<R> {

    R call(Jedis jedis);

}
