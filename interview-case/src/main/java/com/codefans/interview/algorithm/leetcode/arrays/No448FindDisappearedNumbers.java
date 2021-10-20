package com.codefans.interview.algorithm.leetcode.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到数组中消失的数字
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 *
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * @author: codefans
 * @Date: 2021/10/20 09:56
 * @since: 1.0.0
 */
public class No448FindDisappearedNumbers {

    /**
     * 示例 1：
     *      输入：nums = [4,3,2,7,8,2,3,1]
     *      输出：[5,6]
     *
     * 示例 2：
     *      输入：nums = [1,1]
     *      输出：[2]
     *
     * 进阶：
     *     你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
     *
     * 错误用例：
     *    [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,32]
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>(8);
        int n = nums.length;
        for(int i = 0; i < n; i ++) {
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }
        for(int i = 0; i < n; i ++) {
            if(nums[i] <= n) {
                disappearedNumbers.add(i + 1);
            }
        }
        return disappearedNumbers;
    }

    /**
     * 空间复杂度：O(n)
     * 时间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>(8);
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++) {
            arr[nums[i] - 1] = 1;
        }
        for(int i = 0; i < n; i ++) {
            if(arr[i] == 0) {
                disappearedNumbers.add(i + 1);
            }
        }
        return disappearedNumbers;
    }

    /**
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 报：超出时间限制
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>(8);
        int n = nums.length;
        for(int i = 1; i <= n; i ++) {
            boolean findI = false;
            for(int j = 0; j < n; j ++) {
                if(nums[j] == i) {
                    findI = true;
                    break;
                }
            }
            if(!findI) {
                disappearedNumbers.add(i);
            }
        }
        return disappearedNumbers;
    }

}