package com.codefans.interview.algorithm.leetcode.arrays;


import org.junit.Test;

/**
 *
 *
 *
 * @author: codefans
 * @Date: 2021/09/30 17:04
 * @since: 1.0.0
 */
public class No137SingleNumberTest {

    @Test
    public void singleNumberTest() {
        int[][] arr = new int[][] {
            {2,2,2,1},
            {4,1,2,1,2,1,2},
            {1,3,3,3},
            {1,2,3,1,2,1,2},
        };
        No137SingleNumber no137SingleNumber = new No137SingleNumber();
        for(int i = 0; i < arr.length; i ++) {
//            System.out.println(no137SingleNumber.singleNumber(arr[i]));
            System.out.println(no137SingleNumber.singleNumber2(arr[i]));
        }
    }
}