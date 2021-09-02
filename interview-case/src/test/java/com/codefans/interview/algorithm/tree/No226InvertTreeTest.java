/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No226InvertTreeTest
 * Author:   caishengzhi
 * Date:     2021/8/24 19:03
 * Description: 翻转二叉树（二叉树镜像）测试
 */
package com.codefans.interview.algorithm.tree;

import com.codefans.interview.algorithm.common.TreeNodeUtils;
import com.codefans.interview.algorithm.leetcode.tree.No226InvertTree;
import com.codefans.reusablecode.common.BinaryTreeFactory;
import com.codefans.reusablecode.datastructure.binarytree.BinaryTreeNode;
import org.junit.Test;

/**
 *
 * 翻转二叉树（二叉树镜像）测试
 *
 * @author: codefans
 * @Date: 2021/08/24 19:03
 * @since: 1.0.0
 */
public class No226InvertTreeTest {

    /**
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     */
    @Test
    public void invertTreeTest() {

        BinaryTreeFactory treeFactory = new BinaryTreeFactory();
//        BinaryTreeNode treeNode = treeFactory.createBinaryTreeNode();

//        Integer[] arr = new Integer[]{10, 9, 4, 11, null, 5, null};
        Integer[] arr = new Integer[]{4,2,7,1,3,6,9};
        BinaryTreeNode treeNode = treeFactory.createBinaryTree(arr);
        treeFactory.print(treeNode);

        No226InvertTree no226InvertTree = new No226InvertTree();
        BinaryTreeNode invertTreeNode = no226InvertTree.invertTree(treeNode);
        treeFactory.print(invertTreeNode);

    }
}