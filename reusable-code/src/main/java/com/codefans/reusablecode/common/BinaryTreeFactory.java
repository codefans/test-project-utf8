package com.codefans.reusablecode.common;

import com.codefans.reusablecode.datastructure.binarytree.BinaryTreeNode;

import java.util.LinkedList;

/**
 * @author: codefans
 * @date: 2017-09-28 10:52
 **/
public class BinaryTreeFactory implements TreeFactory<BinaryTreeNode> {

    private final String TREE_TYPE_BINARY = "binary";

    @Override
    public BinaryTreeNode create(String treeType) {
        BinaryTreeNode binaryTreeNode = null;
        if(TREE_TYPE_BINARY.equals(treeType)) {
            binaryTreeNode = this.createBinaryTreeNode();
        }
        return binaryTreeNode;
    }

    /**
     *      10
     *     /  \
     *    9    4
     *   / \  / \
     *  11 3 5   12
     * / \  / \
     *13 6 8  14
     * 先序遍历：10, 9, 11, 13, 6, 3, 4, 5, 8, 14, 12
     * 中序遍历：13, 11, 6, 9, 3, 10, 8, 5, 14, 4, 12
     * 后序遍历：13, 6, 11, 3, 9, 8, 14, 5, 12, 4, 10
     * @return
     */
    
    /**
     *      10
     *     /  \
     *    9    4
     *   / \  /
     *  11 3 5
     * 先序遍历：10, 9, 11, 3, 4, 5
     * 中序遍历：11, 9, 3, 10, 5, 4
     * 后序遍历：11, 3, 9, 5, 4, 10
     * @return
     */
    public BinaryTreeNode createBinaryTreeNode() {
        BinaryTreeNode rootNode = new BinaryTreeNode();
        rootNode.setValue(10);
        BinaryTreeNode left = new BinaryTreeNode();
        left.setValue(9);
        BinaryTreeNode right = new BinaryTreeNode();
        right.setValue(4);
        rootNode.setLeft(left);
        rootNode.setRight(right);

        BinaryTreeNode threeLeftPartLeftNode = new BinaryTreeNode();
        threeLeftPartLeftNode.setValue(11);
        BinaryTreeNode threeLeftPartRightNode = new BinaryTreeNode();
        threeLeftPartRightNode.setValue(3);
        left.setLeft(threeLeftPartLeftNode);
        left.setRight(threeLeftPartRightNode);

        BinaryTreeNode threeRightPartLeftNode = new BinaryTreeNode();
        threeRightPartLeftNode.setValue(5);
//        BinaryTreeNode threeRightPartRightNode = new BinaryTreeNode();
//        threeRightPartRightNode.setValue(12);
        right.setLeft(threeRightPartLeftNode);
//        right.setRight(threeRightPartRightNode);

//        BinaryTreeNode fourLeftPartLeftNode = new BinaryTreeNode();
//        fourLeftPartLeftNode.setValue(13);
//        BinaryTreeNode fourLeftPartRightNode = new BinaryTreeNode();
//        fourLeftPartRightNode.setValue(6);
//        threeLeftPartLeftNode.setLeft(fourLeftPartLeftNode);
//        threeLeftPartLeftNode.setRight(fourLeftPartRightNode);
//
//        BinaryTreeNode fourRightPartLeftNode = new BinaryTreeNode();
//        fourRightPartLeftNode.setValue(8);
//        BinaryTreeNode fourRightPartRightNode = new BinaryTreeNode();
//        fourRightPartRightNode.setValue(14);
//        threeRightPartLeftNode.setLeft(fourRightPartLeftNode);
//        threeRightPartLeftNode.setRight(fourRightPartRightNode);

        return rootNode;
    }

    /**
     * 根据数组创建一个二叉树
     * @param arr
     * @return
     */
    public BinaryTreeNode createBinaryTree(Integer[] arr) {
        BinaryTreeNode root = null;
        int len;
        if(arr != null && arr.length > 0) {
            len = arr.length;
            root = new BinaryTreeNode(arr[0]);
            BinaryTreeNode left;
            BinaryTreeNode right;
            BinaryTreeNode curr;
            LinkedList<BinaryTreeNode> queue = new LinkedList<>();
            queue.push(root);
            Integer curVal;
            for(int i = 1; i < len; i = i + 2) {
                curr = queue.removeLast();
                if(curr != null) {
                    curVal = arr[i];
                    if(curVal != null) {
                        left = new BinaryTreeNode(arr[i]);
                        curr.setLeft(left);
                        queue.addFirst(left);
                    } else {
                        curr.setLeft(null);
                    }
                    curVal = arr[i+1];
                    if(curVal != null) {
                        right = new BinaryTreeNode(arr[i + 1]);
                        curr.setRight(right);
                        queue.addFirst(right);
                    } else {
                        curr.setRight(null);
                    }
                }
            }
        }
        return root;
    }

    /**
     * 中序遍历-输出二叉树
     * @param treeNode
     */
    public static void print(BinaryTreeNode treeNode) {
        printRecursion(treeNode);
        System.out.println();
    }

    /**
     * 按层级打印二叉树
     * @param treeNode
     */
    public static void printByLevel(BinaryTreeNode treeNode) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        BinaryTreeNode currNode = null;
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;
        boolean isFirst = true;
        while(!queue.isEmpty()) {
            currNode = queue.removeFirst();
            if(isFirst) {
                System.out.print(currNode.getValue());
                isFirst = false;
            } else {
                System.out.print(", " + currNode.getValue());
            }
            left = currNode.getLeft();
            if(left != null) {
                queue.addLast(left);
            }
            right = currNode.getRight();
            if(right != null) {
                queue.addLast(right);
            }
        }
        System.out.println();
    }

    public static void printRecursion(BinaryTreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.print(treeNode.getValue() + ",");
        printRecursion(treeNode.getLeft());
        printRecursion(treeNode.getRight());
    }

}
