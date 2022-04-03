/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No101SymmetricTreeTest
 * Author:   codefans
 * Date:     2021/9/7 17:36
 * Description: 判断树的对称性测试
 */
package com.codefans.interview.algorithm.tree;


import com.codefans.reusablecode.datastructure.TreeNode;
import com.codefans.reusablecode.datastructure.TreeNodeFactory;
import com.codefans.interview.algorithm.leetcode.tree.No101SymmetricTree;
import com.codefans.reusablecode.common.BinaryTreeFactory;
import com.codefans.reusablecode.datastructure.binarytree.BinaryTreeNode;
import org.junit.Test;

/**
 *
 * 判断树的对称性测试
 *
 * @author: codefans
 * @Date: 2021/09/07 17:36
 * @since: 1.0.0
 */
public class No101SymmetricTreeTest {

    @Test
    public void mirrorTest() {

        No101SymmetricTree no101SymmetricTree = new No101SymmetricTree();
        Integer[] arr = new Integer[]{4,2,7,1,3,6,9};
//        Integer[] arr = new Integer[]{4,7,2,9,6,3,1};
        TreeNode treeNode = TreeNodeFactory.createTreeNode(arr);
        TreeNodeFactory.printByLevel(treeNode);

        TreeNode mirrorNode = no101SymmetricTree.mirror(treeNode);
        TreeNodeFactory.printByLevel(mirrorNode);
    }


    @Test
    public void isSymmetricIterationTest() {

        Integer[] arr = new Integer[]{1,2,2,3,4,4,3};
//        Integer[] arr = new Integer[]{1,2,2,null,3,null,3};
        TreeNode treeNode = TreeNodeFactory.createTreeNode(arr);
        TreeNodeFactory.printByLevel(treeNode);

        No101SymmetricTree no101SymmetricTree = new No101SymmetricTree();
        boolean isSymmetric = no101SymmetricTree.isSymmetricIteration(treeNode);
        System.out.println("isSymmetric=" + isSymmetric);

    }


}
