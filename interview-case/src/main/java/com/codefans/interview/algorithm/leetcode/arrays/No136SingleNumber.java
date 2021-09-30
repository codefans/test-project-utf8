package com.codefans.interview.algorithm.leetcode.arrays;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author: codefans
 *
 * @Date: 2021/09/30 17:02
 * @since: 1.0.0
 */
public class No136SingleNumber {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        for(int i = 1; i < nums.length; i ++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int result = -1;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i ++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for(int i = 0;i < len; i ++) {
            if(map.get(nums[i]) == 1) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

}