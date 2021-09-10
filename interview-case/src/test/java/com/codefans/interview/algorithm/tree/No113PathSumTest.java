/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No113PathSumTest
 * Author:   caishengzhi
 * Date:     2021/9/9 11:42
 * Description: 二叉树中和为某一个值的路径
 */
package com.codefans.interview.algorithm.tree;


import com.codefans.interview.algorithm.common.TreeNode;
import com.codefans.interview.algorithm.common.TreeNodeFactory;
import com.codefans.interview.algorithm.leetcode.tree.No110BalancedBinaryTree;
import com.codefans.interview.algorithm.leetcode.tree.No113PathSum;
import org.junit.Test;

import java.util.List;

/**
 *
 * 二叉树中和为某一个值的路径测试
 *
 * @author: codefans
 * @Date: 2021/09/09 11:42
 * @since: 1.0.0
 */
public class No113PathSumTest {

    /**
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *
     */
    @Test
    public void pathSumTest() {

        Integer[][] testArr = new Integer[][]{
                {5,4,8,11,null,13,4,7,2,null,null,5,1}
        };
        int targetSum = 22;

        for(int i = 0; i < testArr.length; i ++) {

            TreeNode treeNode = TreeNodeFactory.createTreeNode(testArr[i]);
            TreeNodeFactory.printByLevel(treeNode);

            No113PathSum no113PathSum = new No113PathSum();
//            List<List<Integer>> list = no113PathSum.pathSumDfs(treeNode, targetSum);
            List<List<Integer>> list = no113PathSum.pathSumBfs(treeNode, targetSum);
            no113PathSum.print(list);

        }

    }
}