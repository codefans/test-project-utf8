package com.codefans.interview.algorithm.common;

/**
 * @author: codefans
 * @date: 2019-10-05 22:03
 */
public class TreeNodeUtils {

    /**
     * 中序遍历-输出二叉树
     * @param treeNode
     */
    public static void print(TreeNode treeNode) {
        printRecursion(treeNode);
        System.out.println();
    }

    public static void printRecursion(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + ",");
        print(treeNode.left);
        print(treeNode.right);
    }

}
