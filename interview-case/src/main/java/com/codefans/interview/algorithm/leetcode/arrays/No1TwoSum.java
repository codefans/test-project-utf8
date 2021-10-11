package com.codefans.interview.algorithm.leetcode.arrays;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 计算两数之和
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 *
 * @author: codefans
 * @Date: 2021/10/11 17:57
 * @since: 1.0.0
 */
public class No1TwoSum {

    /**
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * 示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] indexArr = null;
        int len = nums.length;
        Map<Integer/*data*/, Integer/*index*/> dataMap = new HashMap<>();
        for(int i = 0; i < len; i ++) {
            if(dataMap.containsKey(target - nums[i])) {
                indexArr = new int[]{dataMap.get(target - nums[i]), i};
                break;
            }
            dataMap.put(nums[i], i);
        }
        return indexArr;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] indexArr = null;
        int len = nums.length;
        for(int i = 0; i < len - 1; i ++) {
            for(int j = i + 1; j < len; j ++) {
                if(nums[i] + nums[j] == target) {
                    indexArr = new int[]{i, j};
                }
            }
        }
        return indexArr;
    }

}