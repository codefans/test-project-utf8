/**
 * Copyright (C), 2015-2021, 京东
 * FileName: PostorderTraversalOfBinaryTree
 * Author:   caishengzhi
 * Date:     2021/9/13 14:25
 * Description: 判断数据是否是二叉树的后序遍历
 */
package com.codefans.interview.algorithm.offer;


import java.util.Arrays;
import java.util.Stack;

/**
 *
 * 判断数据是否是二叉树的后序遍历
 *
 * @author: codefans
 * @Date: 2021/09/13 14:25
 * @since: 1.0.0
 */
public class PostorderTraversalOfBinaryTree {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
     * 假设输入的数组的任意两个数字都互不相同。
     *
     * 示例 1：
     * 输入: [1,6,3,2,5]
     * 输出: false
     *
     * 示例 2：
     * 输入: [1,3,2,6,5]
     * 输出: true
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
//        return verifyPostorder(postorder, postorder.length);
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int len) {
        boolean isPostOrder = false;
        if(postorder == null) {
            return isPostOrder;
        }
        if(len <= 0) {
            return true;
        }
        int root = postorder[len - 1];
        int i = 0;
        for(; i < len - 1; i ++) {
            if(postorder[i] > root) {
                break;
            }
        }
        int j = i;
        for(; j < len - 1; j ++) {
            if(postorder[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if(i > 0) {
            left = verifyPostorder(postorder, i);
        }
        boolean right = true;
        if(i < len - 1) {
            right = verifyPostorder(Arrays.copyOfRange(postorder, i, len - 1), len - i - 1);
        }
        return (left && right);
    }

    /**
     * 解法2：递归分治
     * 题解地址: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
     *
     * @param postorder
     * @param i
     * @param j
     * @return
     */
    public boolean verifyPostorder(int[] postorder, int i, int j) {
        /**
         * 当i>=j, 说明此子树节点数量≤1, 无需判别正确性, 因此直接返回 true
         */
        if(i >= j) {
            return true;
        }
        /**
         * p必须从i开始遍历, 而不是每次都从0开始遍历
         */
        int p = i;
        while(postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while(postorder[p] > postorder[j]) {
            p++;
        }
        /**
         * 之前错的地方: 判断右子树的范围错了, 写成了[m, j], 导致死循环;
         * 那为什么是j-1呢? 因为是后序遍历, 最后一个节点是根节点, 不能包含在右子树范围内.
         */
        return (p == j) && verifyPostorder(postorder, i, m - 1) && verifyPostorder(postorder, m, j - 1);
    }

    /**
     * 解法3：单调栈
     * 解法地址： https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorderByMonotoneStack(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }


}
