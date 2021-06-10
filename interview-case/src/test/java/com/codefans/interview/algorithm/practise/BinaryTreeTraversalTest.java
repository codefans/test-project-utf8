/**
 * Copyright (C), 2015-2021, 京东
 * FileName: BinaryTreeTraversalTest
 * Author:   caishengzhi
 * Date:     2021/6/8 17:23
 * Description: 二叉树遍历测试类
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.TreeNode;
import com.codefans.interview.algorithm.common.TreeNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 二叉树遍历测试类
 *
 * @author: codefans
 * @Date: 2021/06/08 17:23
 * @since: 1.0.0
 */
public class BinaryTreeTraversalTest {

    /**
     *
     */
    private BinaryTreeTraversal binaryTreeTraversal;

    @Before
    private void before() {
        binaryTreeTraversal = new BinaryTreeTraversal();
    }

    @Test
    public void fisrtOrderTraversalTest() {

        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        treeNode.left = left;
        treeNode.right = right;
        binaryTreeTraversal.fisrtOrderTraversal(treeNode);

    }

}