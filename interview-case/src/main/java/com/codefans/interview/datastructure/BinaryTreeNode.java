package com.codefans.interview.datastructure;

/**
 * @Author: codefans
 * @Date: 2018-12-12 7:35
 * 二叉树
 */

public class BinaryTreeNode {

    private int value;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
