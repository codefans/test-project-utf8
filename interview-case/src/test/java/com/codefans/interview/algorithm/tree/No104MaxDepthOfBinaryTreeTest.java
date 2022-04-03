/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No104MaxDepthOfBinaryTreeTest
 * Author:   codefans
 * Date:     2021/9/9 9:47
 * Description: 二叉树的最大深度测试
 */
package com.codefans.interview.algorithm.tree;


import com.codefans.interview.algorithm.common.TreeNode;
import com.codefans.interview.algorithm.common.TreeNodeFactory;
import com.codefans.interview.algorithm.leetcode.tree.No104MaxDepthOfBinaryTree;
import org.junit.Test;

/**
 *
 * 二叉树的最大深度测试
 *
 * @author: codefans
 * @Date: 2021/09/09 09:47
 * @since: 1.0.0
 */
public class No104MaxDepthOfBinaryTreeTest {

    @Test
    public void maxDepthTest() {

        Integer[] arr = new Integer[]{3,9,20,null,null,15,7}; //maxDepth=3
        TreeNode treeNode = TreeNodeFactory.createTreeNode(arr);
        TreeNodeFactory.printByLevel(treeNode);
        No104MaxDepthOfBinaryTree no104MaxDepthOfBinaryTree = new No104MaxDepthOfBinaryTree();
        int maxDepth = no104MaxDepthOfBinaryTree.maxDepthIteration(treeNode);
        System.out.println("maxDepth=" + maxDepth);

    }
}