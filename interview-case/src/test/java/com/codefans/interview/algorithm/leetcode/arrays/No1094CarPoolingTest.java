package com.codefans.interview.algorithm.leetcode.arrays;

import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2022-04-20 0:13
 */

public class No1094CarPoolingTest {

    @Test
    public void calPoolingTest() {

        int[][] trips = new int[][]{
            {2,1,5},
            {3,3,7}
        };
//        int capacity = 4; //false
        int capacity = 5; //true
        No1094CarPooling no1094CarPooling = new No1094CarPooling();
        boolean result = no1094CarPooling.carPooling(trips, capacity);
        System.out.println(result);

    }
}
