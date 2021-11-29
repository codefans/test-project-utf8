package com.codefans.interview.algorithm.leetcode.arrays;

import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2021-11-06 0:41
 */

public class No88MergeSortedArrayTest {
    
    @Test
    public void mergeTest() {
       
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3, n = 3;
        No88MergeSortedArray no88MergeSortedArray = new No88MergeSortedArray();
        no88MergeSortedArray.merge(nums1, m ,nums2, n);
        PrintUtils.printIntArray(nums1);

        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
        no88MergeSortedArray.merge(nums1, m ,nums2, n);
        PrintUtils.printIntArray(nums1);

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
        no88MergeSortedArray.merge(nums1, m ,nums2, n);
        PrintUtils.printIntArray(nums1);
    }
}
