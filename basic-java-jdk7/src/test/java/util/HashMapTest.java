package util;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: codefans
 * @Date: 2019-07-21 17:15
 */

public class HashMapTest {

    @Before
    public void before() {

        System.setProperty("jdk.map.althashing.threshold", "100000");

    }

    @Test
    public void test() {

        String altThreshold = java.security.AccessController.doPrivileged(
                new sun.security.action.GetPropertyAction(
                        "jdk.map.althashing.threshold"));
        System.out.println("altThreadhold:" + altThreshold);

    }

    @Test
    public void roundUpToPowerOf2() {

        int initialCapacity = 6;

        //jdk 1.6
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        System.out.println("jdk1.6 capacity=" + capacity);

        //jdk 1.7
        int MAXIMUM_CAPACITY = 1 << 30;

        int resultCapacity = initialCapacity >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (initialCapacity > 1) ? Integer.highestOneBit((initialCapacity - 1) << 1) : 1;
        System.out.println("jdk1.7 capacity=" + resultCapacity);


    }

    @Test
    public void twoRoundUpToPowerOf2MethodCompare() {

//        int[] initialCapacity = new int[]{
//            1,3,5,6,7,9,10,11,12,13,14,15,17,18,19,10
//        };

        int maxCapacity = 10000000;
        Integer[] initialCapacity = this.getInitCapacityArray(maxCapacity);
        System.out.println("initialCapacity.length:" + initialCapacity.length);

        //jdk 1.6
        long beginTime = System.currentTimeMillis();
        for(int i : initialCapacity) {
            this.findMinPowerOf2CapacityUseJdk6(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("jdk1.6 time cost=" + (endTime - beginTime) / 1000 + "s");

        //jdk 1.7
        beginTime = System.currentTimeMillis();
        for(int i : initialCapacity) {
            this.findMinPowerOf2CapacityUseJdk7(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("jdk1.7 time cost=" + (endTime - beginTime) / 1000 + "s");



    }

    public Integer[] getInitCapacityArray(int maxCapacity) {
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < maxCapacity; i ++) {
            if(i % 2 != 0) {
                arr.add(i);
            }
        }
        Integer[] dataArr = new Integer[arr.size()];
        return arr.toArray(dataArr);
    }
    public int findMinPowerOf2CapacityUseJdk6(int initialCapacity) {
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        return capacity;
    }

    public int findMinPowerOf2CapacityUseJdk7(int initialCapacity) {
        int MAXIMUM_CAPACITY = 1 << 30;
        int resultCapacity = initialCapacity >= MAXIMUM_CAPACITY
                ? MAXIMUM_CAPACITY
                : (initialCapacity > 1) ? Integer.highestOneBit((initialCapacity - 1) << 1) : 1;
        return resultCapacity;
    }

}
