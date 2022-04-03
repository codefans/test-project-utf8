/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No101SymmetricTree
 * Author:   caishengzhi
 * Date:     2021/9/7 17:28
 * Description: 判断树是否是对称的
 */
package com.codefans.interview.algorithm.leetcode.tree;


import com.codefans.reusablecode.datastructure.TreeNode;
import com.codefans.reusablecode.datastructure.TreeNodeFactory;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 判断树是否是对称的
 * 二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 二叉树 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * @author: codefans
 * @Date: 2021/09/07 17:28
 * @since: 1.0.0
 */
public class No101SymmetricTree {

    /**
     * 递归方式判断是否是对称的
     * @param root
     * @return
     */
    public boolean isSymmetricRecursion(TreeNode root) {
        boolean isSymmetric = false;

        return isSymmetric;
    }

    /**
     * 迭代方式判断是否是对称的
     * @param root
     * @return
     */
    public boolean isSymmetricIteration(TreeNode root) {
        boolean isSymmetric = false;
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root.left);
        queue.addLast(root.right);
        TreeNode left;
        TreeNode right;
        while(!queue.isEmpty()) {
            left = queue.removeFirst();
            right = queue.removeFirst();
            if(left == null && right == null) {
                continue;
            }
            if(left == null || right == null) {
                isSymmetric = false;
                break;
            }
            if(left.val == right.val) {
                isSymmetric = true;
            } else {
                isSymmetric = false;
                break;
            }
            queue.addLast(left.left);
            queue.addLast(right.right);
            queue.addLast(left.right);
            queue.addLast(right.left);
        }
        return isSymmetric;
    }

    /**
     * 返回树的镜像
     * @param root
     * @return
     */
    public TreeNode mirror(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curNode;
        TreeNode left;
        TreeNode right;
        while(!queue.isEmpty()) {
            curNode = queue.removeFirst();
            left = curNode.left;
            if(left != null) {
                queue.addLast(left);
            }
            right = curNode.right;
            if(right != null) {
                queue.addLast(right);
            }
            curNode.left = right;
            curNode.right = left;
        }
        return root;
    }

}
