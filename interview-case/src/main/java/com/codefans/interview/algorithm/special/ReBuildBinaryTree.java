package com.codefans.interview.algorithm.special;

import com.codefans.interview.algorithm.common.BinaryTreeIterator;
import com.codefans.interview.datastructure.BinaryTreeNode;

/**
 * @Author: codefans
 * @Date: 2018-12-12 7:36
 * 重建二叉树
 */

public class ReBuildBinaryTree {

    private BinaryTreeNode treeNode;

    public static void main(String[] args) {
        ReBuildBinaryTree reBuildBinaryTree = new ReBuildBinaryTree();
        reBuildBinaryTree.runCode();
    }

    public void runCode() {
        this.initBinaryTree();
        this.rebuildBinaryTree();
        this.print();
    }

    public void initBinaryTree() {
        treeNode = new BinaryTreeNode();
        treeNode.setValue(1);

        BinaryTreeNode firstLeft = new BinaryTreeNode();
        firstLeft.setValue(2);

        BinaryTreeNode firstRight = new BinaryTreeNode();
        firstRight.setValue(3);

        treeNode.setLeft(firstLeft);
        treeNode.setRight(firstRight);

        BinaryTreeNode secondLeftLeft = new BinaryTreeNode();
        secondLeftLeft.setValue(4);

        firstLeft.setLeft(secondLeftLeft);

        BinaryTreeNode secondRightLeft = new BinaryTreeNode();
        secondRightLeft.setValue(5);

        BinaryTreeNode secondRightRight = new BinaryTreeNode();
        secondRightRight.setValue(6);

        firstRight.setLeft(secondRightLeft);
        firstRight.setRight(secondRightRight);

        BinaryTreeNode thirdLeftRight = new BinaryTreeNode();
        thirdLeftRight.setValue(7);

        BinaryTreeNode thirdRightLeft = new BinaryTreeNode();
        thirdRightLeft.setValue(8);

        secondLeftLeft.setRight(thirdLeftRight);
        secondRightRight.setLeft(thirdRightLeft);






    }

    public void rebuildBinaryTree() {

    }

    public void print() {

//        BinaryTreeIterator.printPreFirst(treeNode);
        BinaryTreeIterator.printPreFirstByStack(treeNode);
        System.out.println();
//        BinaryTreeIterator.printMidFirst(treeNode);
        BinaryTreeIterator.printMidFirstByStack(treeNode);
        System.out.println();
        BinaryTreeIterator.printRearFirst(treeNode);

    }



}
