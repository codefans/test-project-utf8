package com.codefans.interview.algorithm.leetcode.arrays;


/**
 * No283-移动零
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author: codefans
 * @Date: 2021/10/19 19:26
 * @since: 1.0.0
 */
public class No283MoveZeroes {

    /**
     * 示例:
     *    输入: [0,1,0,3,12]
     *    输出: [1,3,12,0,0]
     *
     * 未考虑到的情况：
     * 输入：[1]
     * 输入：[1,0]
     *
     * 执行用时： 3 ms , 在所有 Java 提交中击败了13.75%的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 18.50%的用户
     * 
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        int len = nums.length;
        if(len <= 1) {
            return;
        }
        for(int i = 0; i < len; i ++) {
            if(nums[i] == 0) {
                if(zeroIndex == -1) {
                    zeroIndex = i;
                } else {
                    continue;
                }
            } else {
                if(zeroIndex >= 0) {
                    swap(nums, zeroIndex, i);
                    if (nums[zeroIndex + 1] == 0) {
                        zeroIndex = zeroIndex + 1;
                    } else {
                        zeroIndex = i;
                    }
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}