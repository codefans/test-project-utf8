package com.codefans.interview.algorithm.leetcode.arrays;


import java.util.ArrayList;
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
}