package com.codefans.interview.algorithm.leetcode.arrays;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 [n/2] 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author: codefans
 * @Date: 2021/10/12 10:21
 * @since: 1.0.0
 */
public class No169MajorityElement {

    /**
     * 示例1：
     * 输入：[3,2,3]
     * 输出：3
     *
     * 示例2：
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     *
     * 进阶：
     * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * 空间复杂度：O(n)
     * 时间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int majority = 0;
        int len = nums.length;
        Map<Integer, Integer> dataMap = new HashMap<>();
        for(int i = 0; i < len; i ++) {
            dataMap.put(nums[i], dataMap.getOrDefault(nums[i], 0) + 1);
            if(dataMap.get(nums[i]) > len / 2) {
                majority = nums[i];
                break;
            }
        }
        return majority;
    }

}
