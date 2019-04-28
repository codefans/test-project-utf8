package com.codefans.basicjava.byteopt;

import org.junit.Test;

import java.util.BitSet;

/**
 * @author:
 * @date: 2019-04-28 20:01:40
 */
public class BitSetTest {

    @Test
    public void test() {
        int[] arr = new int[]{110, 11, 8, 22, 44, 33, 123};
        BitSet bitSet = new BitSet();
        for(int i = 0; i < arr.length; i ++) {
            bitSet.set(arr[i]);
        }

        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));
        System.out.println(bitSet.get(11));

        System.out.println(bitSet);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}
