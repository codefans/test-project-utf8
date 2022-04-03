package com.codefans.interview.algorithm.leetcode.arrays;


/**
 *
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author: codefans
 * @Date: 2021/10/11 18:39
 * @since: 1.0.0
 */
public class No53MaximumSubarray {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], pre = 0;
        for(int n : nums) {
            pre = Math.max(pre + n, n);
            max = Math.max(pre, max);
        }
        return max;
    }

    /**
     * 能算出答案, 但当数组元素比较多时, 提交会超时
     * [-2,1]
     * [-2,-1]
     * [-1,0,-2]
     * 三次提交失败, 是因为这三种情况未考虑。
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int max = 0;
        int len = nums.length;
        if(len == 1) {
            max = nums[0];
        } else {
            for (int i = 0; i < len - 1; i++) {
                int tmp = nums[i];
                for (int j = i + 1; j < len; j++) {
                    tmp += nums[j];
                    if (tmp > max) {
                        max = tmp;
                    }
                }
            }
        }
        return max;
    }

}
