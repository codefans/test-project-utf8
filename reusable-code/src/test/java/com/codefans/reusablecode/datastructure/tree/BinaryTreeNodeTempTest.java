package com.codefans.reusablecode.datastructure.tree;

import com.codefans.reusablecode.common.BinaryTreeFactory;
import com.codefans.reusablecode.common.TreeFactory;
import com.codefans.reusablecode.datastructure.binarytree.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

public class BinaryTreeNodeTempTest {

    BinaryTreeNode binaryTreeNode = null;

    @Before
    public void before() {
        TreeFactory<BinaryTreeNode> treeFactory = new BinaryTreeFactory();
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
        this.binaryTreeNode = treeFactory.create("binary");
    }

    @Test
    public void midFirstTest() {
        this.midFirstRecursion(this.binaryTreeNode);
//        this.midFirstWhile();
    }

    public void midFirstRecursion(BinaryTreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        midFirstRecursion(treeNode.getLeft());
        System.out.println(treeNode.getValue());
        midFirstRecursion(treeNode.getRight());
    }

    public void midFirstWhile() {
        BinaryTreeNode treeNode = this.binaryTreeNode;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();



    }


}
