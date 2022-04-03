/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ConstructBinaryTreeFromPreorderAndInorder
 * Author:   codefans
 * Date:     2021/9/14 10:08
 * Description: 从先序遍历和中序遍历数列中构建二叉树
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.reusablecode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 从先序遍历和中序遍历数列中构建二叉树
 *
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author: codefans
 * @Date: 2021/09/14 10:08
 * @since: 1.0.0
 */
public class ConstructBinaryTreeFromPreorderAndInorder {

    Map<Integer, Integer> dataMap;

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
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeRecursion(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if(preorder == null || preorder.length == 0) {
            return root;
        }
        if(preorder.length == 1) {
            root = new TreeNode(preorder[0]);
            return root;
        }
        dataMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++) {
            dataMap.put(inorder[i], i);
        }
        root = buildTreeRecursion(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    public TreeNode buildTreeRecursion(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        if(preOrderLeft > preOrderRight) {
            return null;
        }
        int rootVal = preorder[preOrderLeft];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIndex = dataMap.get(rootVal);
        int leftSize = inorderRootIndex - inOrderLeft;

        root.left = buildTreeRecursion(preorder, inorder, preOrderLeft + 1, preOrderLeft + leftSize, inOrderLeft, inorderRootIndex - 1);

        root.right = buildTreeRecursion(preorder, inorder, preOrderLeft + leftSize + 1, preOrderRight, inorderRootIndex + 1, inOrderRight);

        return root;
    }


}
