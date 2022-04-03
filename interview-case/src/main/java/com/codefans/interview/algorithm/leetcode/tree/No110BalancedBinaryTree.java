/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No110BalancedBinaryTree
 * Author:   caishengzhi
 * Date:     2021/9/8 10:26
 * Description: 判断是否是平衡二叉树
 */
package com.codefans.interview.algorithm.leetcode.tree;


import com.codefans.reusablecode.datastructure.TreeNode;

/**
 *
 * 判断是否是平衡二叉树
 * 平衡二叉树：即任意节点的左右子树高度差不超过1
 *
 * @author: codefans
 * @Date: 2021/09/08 10:26
 * @since: 1.0.0
 */
public class No110BalancedBinaryTree {

    /**
     * 判断是否是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftDeepLen = maxDepth(root.left);
        int rightDeepLen = maxDepth(root.right);
        if(Math.abs(leftDeepLen - rightDeepLen) > 1) {
            return false;
        }
        return isBalanced(root.left) & isBalanced(root.right);
    }

    /**
     * 求最大深度
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if(root == null) {
            return maxDepth;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        if(leftMaxDepth > rightMaxDepth) {
            maxDepth = leftMaxDepth + 1;
        } else {
            maxDepth = rightMaxDepth + 1;
        }
        //上面这个if-else等价于下面这句话
//        maxDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;
        //也等价于：
//        maxDepth = (leftMaxDepth > rightMaxDepth ? leftMaxDepth : rightMaxDepth) + 1;
        return maxDepth;
    }
}
