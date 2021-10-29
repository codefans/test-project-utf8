package com.codefans.interview.algorithm.leetcode.arrays;


import org.junit.Test;

/**
 * 搜索旋转排序数组测试类
 *
 * @author: codefans
 * @Date: 2021/10/29 10:53
 * @since: 1.0.0
 */
public class No33SearchInRotatedSortedArrayTest {

    @Test
    public void searchTest() {

        int[] arr = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        No33SearchInRotatedSortedArray no33SearchInRotatedSortedArray = new No33SearchInRotatedSortedArray();
        int index = no33SearchInRotatedSortedArray.search(arr, target);
        System.out.println("target=" + target + ", index=" + index);

        arr = new int[]{4,5,6,7,0,1,2};
        target = 3;
        index = no33SearchInRotatedSortedArray.search(arr, target);
        System.out.println("target=" + target + ", index=" + index);

        arr = new int[]{1};
        target = 0;
        index = no33SearchInRotatedSortedArray.search(arr, target);
        System.out.println("target=" + target + ", index=" + index);
    }
}