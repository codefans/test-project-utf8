/**
 * Copyright (C), 2015-2021, 京东
 * FileName: PostorderTraversalOfBinaryTree
 * Author:   caishengzhi
 * Date:     2021/9/13 14:25
 * Description: 判断数据是否是二叉树的后序遍历
 */
package com.codefans.interview.algorithm.offer;


import java.util.Arrays;

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
        return verifyPostorder(postorder, postorder.length);
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


}