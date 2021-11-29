package com.codefans.interview.algorithm.leetcode.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 第46题数组全排列
 *
 * @author: codefans
 * @Date: 2021/11/29 10:48
 * @since: 1.0.0
 */
public class No46Permutation {

    List<List<Integer>> permutationList = new ArrayList<>();

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        permute(nums, list);
        return permutationList;
    }

    /**
     *
     * @param nums
     * @param list
     */
    private void permute(int[] nums, LinkedList<Integer> list) {
        if(nums.length == list.size()) {
            permutationList.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permute(nums, list);
            list.removeLast();
        }
    }

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteOpti(int[] nums) {
        int firstIndex = 0;
        permuteOpti(nums, firstIndex);
        return permutationList;
    }

    /**
     *
     * @param nums
     * @param firstIndex
     */
    private void permuteOpti(int[] nums, int firstIndex) {
        if(firstIndex == nums.length - 1) {
            permutationList.add(this.arr2list(nums));
            return;
        }
        for(int i = firstIndex; i < nums.length; i ++) {
            swap(nums, firstIndex, i);
            permuteOpti(nums, firstIndex + 1);
            swap(nums, firstIndex, i);
        }
    }

    /**
     * 交换下标为i和j的两个元素
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     *
     * @param nums
     * @return
     */
    private List<Integer> arr2list(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>(len);
        for(int n : nums) {
            list.add(new Integer(n));
        }
        return list;
    }
}
