package com.codefans.reusablecode.bigdata.bloomfilter;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

/**
 * @Author: codefans
 * @Date: 2019-07-28 20:33
 */

public class MurmurHash {

    public int guavaMurmur3_128Hash(String str) {
        HashCode hashCode = Hashing.murmur3_128().hashBytes(str.getBytes());
        return hashCode.hashCode();
    }

    public int guavaMurmur3_32Hash(String str) {
        HashCode hashCode = Hashing.murmur3_32().hashBytes(str.getBytes());
        return hashCode.hashCode();
    }

}
