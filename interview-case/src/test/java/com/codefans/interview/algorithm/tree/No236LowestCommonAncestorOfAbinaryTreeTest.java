/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No236LowestCommonAncestorOfAbinaryTreeTest
 * Author:   codefans
 * Date:     2021/9/10 18:13
 * Description: 二叉树的最近公共祖先
 */
package com.codefans.interview.algorithm.tree;


import com.codefans.reusablecode.datastructure.TreeNode;
import com.codefans.reusablecode.datastructure.TreeNodeFactory;
import com.codefans.interview.algorithm.leetcode.tree.No236LowestCommonAncestorOfAbinaryTree;
import org.junit.Test;

/**
 *
 * 二叉树的最近公共祖先
 *
 * @author: codefans
 * @Date: 2021/09/10 18:13
 * @since: 1.0.0
 */
public class No236LowestCommonAncestorOfAbinaryTreeTest {

    /**
     * 示例 1:
     *     输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     *     输出: 3
     *     解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     *
     * 示例 2:
     *     输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     *     输出: 5
     *     解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     */
    @Test
    public void lowestCommonAncestorTest() {

        Integer[][] arr = new Integer[][]{
            {3,5,1,6,2,0,8,null,null,7,4}
        };
        No236LowestCommonAncestorOfAbinaryTree lowestCommonAncestor = new No236LowestCommonAncestorOfAbinaryTree();
        for(int i = 0; i < arr.length; i ++) {
            TreeNode root = TreeNodeFactory.createTreeNode(arr[i]);
            TreeNode p = TreeNodeFactory.getTreeNode(root, 5);
            TreeNode q = TreeNodeFactory.getTreeNode(root, 1);
            System.out.println("p.val=" + p.val + ", q.val=" + q.val);
            TreeNode commonAncestor = lowestCommonAncestor.lowestCommonAncestor(root, p, q);
            System.out.println("commonAncestor=" + commonAncestor.val);
        }


    }


}
