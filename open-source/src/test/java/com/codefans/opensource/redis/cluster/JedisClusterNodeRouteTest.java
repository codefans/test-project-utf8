package com.codefans.opensource.redis.cluster;

import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-07-11 11:39
 */
public class JedisClusterNodeRouteTest {

    @Test
    public void nodeRouteByKeyTest() {

        String[] keys = new String[]{
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "serven",
            "eight",
            "nigh",
            "ten",
            "eleven",
        };
        String[] hostArr = new String[]{
                "127.0.0.1:3793",
                "127.0.0.1:3794",
                "127.0.0.1:3795",
                "127.0.0.1:3796",
                "127.0.0.1:3797",
                "127.0.0.1:3798",
        };
        String password = "redisPass123";
        DefaultJedisCluster jedisCluster = new DefaultJedisCluster(hostArr, password);

        for(String key : keys) {
            jedisCluster.set(key, key + "_value");
            System.out.println(jedisCluster.getJedisCluster());
            System.out.println("key=" + key + ", node=" + JedisClusterNodeRoute.getSlot(key));
        }








    }


    @Test
    public void parseNodeSlotsMapTest() {

        JedisClusterNodeRoute jedisClusterNodeRoute = new JedisClusterNodeRoute();
        jedisClusterNodeRoute.parseNodeSlotsMap();

    }



}
