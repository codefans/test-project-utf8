package com.codefans.interview.algorithm.leetcode.arrays;


import com.codefans.reusablecode.util.PrintUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * No4查找排序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * @author: codefans
 * @Date: 2021/10/22 14:20
 * @since: 1.0.0
 */
public class No4FindMedianSortedArrays {

    /**
     * 示例 1：
     *    输入：nums1 = [1,3], nums2 = [2]
     *    输出：2.00000
     *    解释：合并数组 = [1,2,3] ，中位数 2
     *
     * 示例 2：
     *    输入：nums1 = [1,2], nums2 = [3,4]
     *    输出：2.50000
     *    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     * 示例 3：
     *    输入：nums1 = [0,0], nums2 = [0,0]
     *    输出：0.00000
     *
     * 示例 4：
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     *
     * 示例 5：
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0 && len2 == 1) {
            median = new Double(nums2[0]);
            return median;
        }
        if(len1 == 1 && len2 == 0) {
            median = new Double(nums1[0]);
            return median;
        }
        int[] newArr = new int[len1+len2];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while(index1 < len1 && index2 < len2) {
            if(nums1[index1] <= nums2[index2]) {
                newArr[index++] = nums1[index1++];
            } else {
                newArr[index++] = nums2[index2++];
            }
        }
        while(index1 < len1) {
            newArr[index++] = nums1[index1++];
        }
        while(index2 < len2) {
            newArr[index++] = nums2[index2++];
        }
        PrintUtils.printIntArray(newArr);
        int newLen = newArr.length;
        if(newLen % 2 != 0) {
            median = new Double(newArr[(newLen - 1)/2]);
        } else {
            int low = newArr[newLen/2 - 1];
            int high = newArr[newLen/2];
            BigDecimal lowDecimal = new BigDecimal(low);
            BigDecimal highDecimal = new BigDecimal(high);
            BigDecimal sum = lowDecimal.add(highDecimal);
            median = (sum.divide(new BigDecimal(2), 5, RoundingMode.HALF_DOWN)).doubleValue();
        }
        return median;
    }

}
