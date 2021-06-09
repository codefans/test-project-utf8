/**
 * Copyright (C), 2015-2021, 京东
 * FileName: BaniryTreeIterator
 * Author:   caishengzhi
 * Date:     2021/6/8 16:13
 * Description: 二叉树的遍历
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.TreeNode;

/**
 *
 * 二叉树的遍历
 *
 * @author: codefans
 * @Date: 2021/06/08 16:13
 * @since: 1.0.0
 */
public class BinaryTreeTraversal {

    /**
     *
     * @param treeNode
     */
    public void fisrtOrderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        fisrtOrderTraversal(treeNode.left);
        fisrtOrderTraversal(treeNode.right);
    }

    /**
     *
     * @param treeNode
     */
    public void middleOrderTraversal(TreeNode treeNode) {

    }

    /**
     *
     * @param treeNode
     */
    public void postOrderTraversal(TreeNode treeNode) {

    }

}