package com.codefans.interview.algorithm.leetcode.arrays;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 137. 只出现一次的数字 II
 * https://leetcode-cn.com/problems/single-number-ii/
 *
 * @author: codefans
 * @Date: 2021/09/30 18:06
 * @since: 1.0.0
 */
public class No137SingleNumber {

    /**
     * https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
     * 方法一：有限状态自动机
     * @param nums
     * @return
     */
    public int singleNumber0(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    /**
     * https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/
     * 方法四：数字电路设计优化
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

    /**
     * https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/
     * 方法三：数字电路设计
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int aNext = (~a & b & num) | (a & ~b & ~num), bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }


    /**
     *
     * https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
     * 方法二：遍历统计
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/
     * 方法二：依次确定每一个二进制位
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * @param nums
     * @return
     */
    public int singleNumber4(int[] nums) {
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