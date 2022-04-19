package com.codefans.interview.algorithm.leetcode.arrays;

/**
 * 370 区间加法-中等
 * 假设你有一个长度为n的数组，初始情况下所有的数字均为0，你将会被给出k个更新操作。
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, incVal]，你需要将子数组
 * A[startIndex...endIndex](包括startIndex和endIndex)增加incVal。
 * 请返回k次操作后的数组。
 *
 * @Author: codefans
 * @Date: 2022-03-11 7:23
 *
 * nums  8  5   9   6   1
 * diff  8 -3   4   -3  -5
 *
 */

public class No370RangeAddition {

    private int[] diff;

    public No370RangeAddition(int[] nums) {
        int len = nums.length;
        diff = new int[len];
        diff[0] = nums[0];
        for(int i = 1; i < len; i ++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int i, int j, int val) {
        diff[i] += val;
        if(j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for(int i = 1; i < diff.length; i ++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}
