/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No236LowestCommonAncestorOfAbinaryTree
 * Author:   caishengzhi
 * Date:     2021/9/10 18:12
 * Description: 二叉树的最近公共祖先
 */
package com.codefans.interview.algorithm.leetcode.tree;


import com.codefans.reusablecode.datastructure.TreeNode;

/**
 *
 * 二叉树的最近公共祖先
 *
 * @author: codefans
 * @Date: 2021/09/10 18:12
 * @since: 1.0.0
 */
public class No236LowestCommonAncestorOfAbinaryTree {

    /**
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }

}
