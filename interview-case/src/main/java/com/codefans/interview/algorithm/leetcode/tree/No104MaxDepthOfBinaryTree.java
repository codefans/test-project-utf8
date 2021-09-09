/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No104MaxDepthOfBinaryTree
 * Author:   caishengzhi
 * Date:     2021/9/9 9:46
 * Description: 二叉树的最大深度
 */
package com.codefans.interview.algorithm.leetcode.tree;


import com.codefans.interview.algorithm.common.TreeNode;

import java.util.LinkedList;

/**
 *
 * 二叉树的最大深度
 *
 * @author: codefans
 * @Date: 2021/09/09 09:46
 * @since: 1.0.0
 */
public class No104MaxDepthOfBinaryTree {

    /**
     * 求最大深度
     * @param root
     * @return
     */
    public int maxDepthIteration(TreeNode root) {
        int maxDepth = 0;
        if(root == null) {
            return maxDepth;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode top = queue.removeFirst();
                TreeNode left = top.left;
                TreeNode right = top.right;
                if(left != null) {
                    queue.addLast(left);
                }
                if(right != null) {
                    queue.addLast(right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * 递归求最大深度
     * @param root
     * @return
     */
    public int maxDepthRecursion(TreeNode root) {
        int maxDepth = 0;
        if(root == null) {
            return maxDepth;
        }
        int leftMaxDepth = maxDepthRecursion(root.left);
        int rightMaxDepth = maxDepthRecursion(root.right);
        if(leftMaxDepth > rightMaxDepth) {
            maxDepth = leftMaxDepth + 1;
        } else {
            maxDepth = rightMaxDepth + 1;
        }
        return maxDepth;
    }

}