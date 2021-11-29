package com.codefans.interview.algorithm.leetcode.arrays;


import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

import java.util.List;

/**
 * 全排列测试类
 *
 * @author: codefans
 * @Date: 2021/11/29 10:50
 * @since: 1.0.0
 */
public class No46PermutationTest {

    @Test
    public void permuteTest() {

        No46Permutation no46Permutation = new No46Permutation();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permutationList = no46Permutation.permute(nums);
        PrintUtils.printIntListList(permutationList);
    }

}