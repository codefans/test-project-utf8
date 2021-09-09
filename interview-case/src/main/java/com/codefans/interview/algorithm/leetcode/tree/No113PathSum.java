/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No113PathSum
 * Author:   caishengzhi
 * Date:     2021/9/9 11:36
 * Description: 二叉树中和位某一个值的路径
 */
package com.codefans.interview.algorithm.leetcode.tree;


import com.codefans.interview.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 二叉树中和位某一个值的路径
 *
 * @author: codefans
 * @Date: 2021/09/09 11:36
 * @since: 1.0.0
 */
public class No113PathSum {

    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        int curSum = pathSum(root, subList);
        System.out.println("curSum=" + curSum);
        if(curSum == targetSum) {

        }
        return list;
    }

//    /**
//     *
//     * @param root
//     * @param targetSum
//     * @return
//     */
//    private int pathSum(TreeNode root, int targetSum) {
//
//    }

    /**
     * 功能：计算一条路径的和
     * 终止条件：root==null
     * 递推公式：sum(n) = currVal + sum(n-1)
     *
     * @param root
     * @param list
     * @return
     */
    private int pathSum(TreeNode root, List<Integer> list) {
        if(root == null) {
            return 0;
        }
        int curVal = root.val;
        list.add(curVal);
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftSum = pathSum(left, list);
        int rightSum = pathSum(right, list);
        return curVal + (left == null ? rightSum : leftSum);
    }

    public void print(List<List<Integer>> list) {
        for(int i = 0; i < list.size(); i ++) {
            List<Integer> subList = list.get(i);
            for(int j = 0; j < subList.size(); j ++) {
                if(j != 0) {
                    System.out.print(",");
                }
                System.out.print(subList.get(j));
            }
            System.out.println();
        }
    }

}