/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No110BalancedBinaryTreeTest
 * Author:   codefans
 * Date:     2021/9/8 10:30
 * Description: 判断是否是平衡二叉树
 */
package com.codefans.interview.algorithm.tree;


import com.codefans.interview.algorithm.common.TreeNode;
import com.codefans.interview.algorithm.common.TreeNodeFactory;
import com.codefans.interview.algorithm.leetcode.tree.No110BalancedBinaryTree;
import org.junit.Test;

/**
 *
 * 判断是否是平衡二叉树
 * [3,9,20,null,null,15,7] 返回true
 * [1,2,2,3,3,null,null,4,4] 返回false
 * @author: codefans
 * @Date: 2021/09/08 10:30
 * @since: 1.0.0
 */
public class No110BalancedBinaryTreeTest {

    @Test
    public void isBalancedTest() {

//        Integer[] arr = new Integer[]{3,9,20,null,null,15,7}; //true
//        Integer[] arr = new Integer[]{1,2,2,3,3,null,null,4,4}; //false
//        Integer[] arr = new Integer[]{}; //true
//        Integer[] arr = new Integer[]{1,null,3,2}; //false
        Integer[] arr = new Integer[]{1,2,2,3,null,null,3,4,null,null,4}; //false

        Integer[][] testArr = new Integer[][]{
            {3,9,20,null,null,15,7},
            {1,2,2,3,null,null,3,4,null,null,4},
            {},
            {1,null,3,2},
            {1,2,2,3,null,null,3,4,null,null,4}
        };
        for(int i = 0; i < testArr.length; i ++) {
            TreeNode treeNode = TreeNodeFactory.createTreeNode(testArr[i]);
            TreeNodeFactory.printByLevel(treeNode);

            No110BalancedBinaryTree no110BalancedBinaryTree = new No110BalancedBinaryTree();
            boolean isBalanced = no110BalancedBinaryTree.isBalanced(treeNode);
            System.out.println("isBalanced=" + isBalanced);
        }

    }

}