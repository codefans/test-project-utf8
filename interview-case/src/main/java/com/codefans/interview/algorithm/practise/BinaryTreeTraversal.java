/**
 * Copyright (C), 2015-2021, 京东
 * FileName: BaniryTreeIterator
 * Author:   codefans
 * Date:     2021/6/8 16:13
 * Description: 二叉树的遍历
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.reusablecode.datastructure.TreeNode;

import java.util.Stack;

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
    public void fisrtOrderTraversal2(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        TreeNode curr = treeNode;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);
        while(!stack.isEmpty()) {
            curr = stack.pop();
            if(curr != null) {
                System.out.println(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
    }

    /**
     *
     * @param treeNode
     */
    public void middleOrderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        middleOrderTraversal(treeNode.left);
        System.out.println(treeNode.val);
        middleOrderTraversal(treeNode.right);
    }

    /**
     *
     * @param treeNode
     */
    public void postOrderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.println(treeNode.val);
    }

}
