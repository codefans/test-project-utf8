package com.codefans.reusablecode.bigdata;

import com.codefans.reusablecode.bigdata.bloomfilter.MurmurHash;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-07-28 20:40
 */

public class MurmurHashTest {

    private String[] keys;
    private MurmurHash murmurHash;

    @Before
    public void before() {
        int keyNum = 50;
        keys = new String[keyNum];
        for(int i = 0; i < keys.length; i ++) {
            keys[i] = "redis-cluster-node-" + i;
        }
        murmurHash = new MurmurHash();
    }
    @Test
    public void murmurHashTest() {

        this.murmur3_32Hash();
        this.murmur3_128Hash();

    }

    public void murmur3_32Hash() {
        System.out.println("murmur3_32哈希算法:");
        for(int i = 0; i < keys.length; i ++) {
            System.out.println("key:[" + keys[i] + "], hashcode:[" + murmurHash.guavaMurmur3_32Hash(keys[i]) + "]");
        }
    }

    public void murmur3_128Hash() {
        System.out.println("murmur3_128哈希算法:");
        for(int i = 0; i < keys.length; i ++) {
            System.out.println("key:[" + keys[i] + "], hashcode:[" + murmurHash.guavaMurmur3_128Hash(keys[i]) + "]");
        }
    }

}
