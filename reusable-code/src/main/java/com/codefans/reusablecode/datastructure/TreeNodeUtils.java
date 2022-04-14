package com.codefans.reusablecode.datastructure;

import java.util.LinkedList;

/**
 * @author: codefans
 * @date: 2019-10-05 22:03
 */
public class TreeNodeUtils {

    private static int indentCount = 0;

    /**
     * 中序遍历-输出二叉树
     * @param treeNode
     */
    public static void print(TreeNode treeNode) {
        printBreadthFirst(treeNode);
        resetIndent();
    }

    /**
     * 深度优先遍历
     * @param treeNode
     */
    public static void printDepthFirst(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.println(treeNode.val + ",");
        print(treeNode.left);
        print(treeNode.right);
    }

    /**
     * 广度优先遍历
     * @param treeNode
     */
    public static void printBreadthFirst(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(treeNode);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i ++) {
                TreeNode rootNode = queue.removeFirst();
                printIndent(level);
                if(rootNode != null) {
                    System.out.println(rootNode.val);
                    queue.addLast(rootNode.left);
                    queue.addLast(rootNode.right);
                }
            }
            level++;
        }
        System.out.println("树的深度(层级)为:[" + level + "]");
    }

    /**
     * 打印缩进
     */
    public static void printIndent(int n) {
        for(int i = 0; i < n; i ++) {
            System.out.print("    ");
        }
    }

    public static void resetIndent() {
        indentCount = 0;
    }

}
