package com.codefans.interview.algorithm.leetcode.arrays;


import org.junit.Test;

/**
 * No4查找排序数组的中位数测试类
 *
 * @author: codefans
 * @Date: 2021/10/22 14:21
 * @since: 1.0.0
 */
public class No4FindMedianSortedArraysTest {

    @Test
    public void findMedianSortedArraysTest() {
//        int[] arr1 = new int[]{1,2};
//        int[] arr2 = new int[]{3,4};

//        int[] arr1 = new int[]{1,3};
//        int[] arr2 = new int[]{2};

//        int[] arr1 = new int[]{0,0};
//        int[] arr2 = new int[]{0,0};

//        int[] arr1 = new int[]{};
//        int[] arr2 = new int[]{1};

        int[] arr1 = new int[]{2};
        int[] arr2 = new int[]{};

        No4FindMedianSortedArrays no4FindMedianSortedArrays = new No4FindMedianSortedArrays();
        double median = no4FindMedianSortedArrays.findMedianSortedArrays(arr1, arr2);
        System.out.println("median=" + median);
    }


}