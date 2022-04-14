/**
 * Copyright (C), 2015-2021, 京东
 * FileName: TreeNodeFactory
 * Author:   codefans
 * Date:     2021/6/8 17:25
 * Description: 二叉树工厂
 */
package com.codefans.reusablecode.datastructure;

import java.util.LinkedList;

/**
 *
 * 二叉树工厂
 *
 * @author: codefans
 * @Date: 2021/06/08 17:25
 * @since: 1.0.0
 */
public class TreeNodeFactory {

    /**
     * 根据数组创建二叉树
     * @param arr
     * @return
     */
    public static TreeNode createTreeNode(Integer[] arr) {
        TreeNode treeNode = null;
        if(arr == null || arr.length == 0) {
            return treeNode;
        }
        treeNode = new TreeNode(arr[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(treeNode);

        TreeNode curNode = null;
        TreeNode left = null;
        TreeNode right = null;
        Integer curItem = null;
        for(int i = 1; i < arr.length; i = i + 2) {
            curNode = queue.removeFirst();
            curItem = arr[i];
            if(curItem != null) {
                left = new TreeNode(curItem);
                queue.addLast(left);
                curNode.left = left;
            }
            if(i+1 <= arr.length - 1) {
                curItem = arr[i + 1];
                if (curItem != null) {
                    right = new TreeNode(curItem);
                    queue.addLast(right);
                    curNode.right = right;
                }
            }
        }
        return treeNode;
    }

    /**
     * 按层级打印二叉树
     * @param treeNode
     */
    public static void printByLevel(TreeNode treeNode) {
        if(treeNode == null) {
            System.out.println("[]");
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        TreeNode currNode = null;
        TreeNode left = null;
        TreeNode right = null;
        boolean isFirst = true;
        while(!queue.isEmpty()) {
            currNode = queue.removeFirst();
            if(isFirst) {
                System.out.print(currNode.val);
                isFirst = false;
            } else {
                System.out.print(", " + currNode.val);
            }
            left = currNode.left;
            if(left != null) {
                queue.addLast(left);
            }
            right = currNode.right;
            if(right != null) {
                queue.addLast(right);
            }
        }
        System.out.println();
    }

    public static TreeNode copy(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode mirrorNode = new TreeNode(root.val);
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> newQueue = new LinkedList<>();
        queue.add(root);
        newQueue.add(mirrorNode);
        TreeNode curNode;
        TreeNode newCurNode;
        TreeNode left;
        TreeNode right;
        while(!queue.isEmpty() && !newQueue.isEmpty()) {
            curNode = queue.removeFirst();
            newCurNode = newQueue.removeFirst();
            left = curNode.left;
            if(left != null) {
                queue.addLast(left);
                newCurNode.left = new TreeNode(left.val);
                newQueue.addLast(newCurNode.left);
            }
            right = curNode.right;
            if(right != null) {
                queue.addLast(right);
                newCurNode.right = new TreeNode(right.val);
                newQueue.addLast(newCurNode.right);
            }
        }
        return mirrorNode;
    }

    /**
     * 在二叉树中，查找值为nodeVal的节点
     * @param root
     * @param nodeVal
     * @return
     */
    public static TreeNode getTreeNode(TreeNode root, int nodeVal) {
        if(root == null || root.val == nodeVal) {
            return root;
        }
        TreeNode left = getTreeNode(root.left, nodeVal);
        TreeNode right = getTreeNode(root.right, nodeVal);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }
}