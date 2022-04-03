/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ConstructBinaryTreeFromPreorderAndInorderTest
 * Author:   codefans
 * Date:     2021/9/14 10:58
 * Description: 根据先序遍历和中序遍历构建二叉树测试类
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.TreeNode;
import com.codefans.interview.algorithm.common.TreeNodeFactory;
import org.junit.Test;

/**
 *
 * 根据先序遍历和中序遍历构建二叉树测试类
 *
 * @author: codefans
 * @Date: 2021/09/14 10:58
 * @since: 1.0.0
 */
public class ConstructBinaryTreeFromPreorderAndInorderTest {

    /**
     *      3
     *     / \
     *    9  20
     *       / \
     *      15  7
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * 示例 2:
     *
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     *
     */
    @Test
    public void buildTreeTest() {

        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        ConstructBinaryTreeFromPreorderAndInorder contructTree = new ConstructBinaryTreeFromPreorderAndInorder();
        TreeNode root = contructTree.buildTreeRecursion(preorder, inorder);
        TreeNodeFactory.printByLevel(root);

    }
}