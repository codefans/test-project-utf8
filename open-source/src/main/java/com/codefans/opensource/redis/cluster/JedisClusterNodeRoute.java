package com.codefans.opensource.redis.cluster;

import redis.clients.util.JedisClusterCRC16;
import redis.clients.util.SafeEncoder;

/**
 * @author: codefans
 * @date: 2019-07-11 11:37
 */
public class JedisClusterNodeRoute {

    /**
     * redis集群共用16384个哈希槽
     */
    private static int total_slot = 16384;

    public static int getSlot(String key) {
        byte[] keyBytes = SafeEncoder.encode(key);
        return JedisClusterCRC16.getSlot(keyBytes);
    }

    /**
     * 获取key所在的节点
     *
     * @param key
     * @param nodeNums
     * @return
     *
     * 如果3个节点
     *      节点 A 包含 0 到 5500号哈希槽.
     *      节点 B 包含5501 到 11000 号哈希槽.
     *      节点 C 包含11001 到 16384号哈希槽.
     * 如果6个节点
     * 16384
     * 	0~2730
     *
     * 	2731~5461
     *
     * 	5462~8192
     *
     * 	8193~10923
     *
     * 	10924~13654
     *
     * 	13655~16384
     *
     */
    public static int getNode(String key, int nodeNums) {
        int nodeIndex = -1;

        return nodeIndex;
    }

}
