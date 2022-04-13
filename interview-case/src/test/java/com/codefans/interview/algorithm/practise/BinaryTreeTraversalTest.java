/**
 * Copyright (C), 2015-2021, 京东
 * FileName: BinaryTreeTraversalTest
 * Author:   codefans
 * Date:     2021/6/8 17:23
 * Description: 二叉树遍历测试类
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.reusablecode.datastructure.TreeNode;
import com.codefans.reusablecode.datastructure.TreeNodeFactory;
import com.codefans.reusablecode.datastructure.TreeNodeUtils;
import com.google.common.base.Stopwatch;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;

/**
 *
 * 二叉树遍历测试类
 *
 * @author: codefans
 * @Date: 2021/06/08 17:23
 * @since: 1.0.0
 */
public class BinaryTreeTraversalTest {

    /**
     *
     */
    private BinaryTreeTraversal binaryTreeTraversal;

    @Before
    public void before() {
        binaryTreeTraversal = new BinaryTreeTraversal();
    }

    @Test
    public void fisrtOrderTraversalTest() {


        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        TreeNode treeNode = TreeNodeFactory.createTreeNode(arr);

        binaryTreeTraversal.fisrtOrderTraversal(treeNode);
//        binaryTreeTraversal.fisrtOrderTraversal2(treeNode);

//        List<Integer> list = new ArrayList<>();
//        int[] arr = (int[])list.toArray(new Integer[0]);


        Stopwatch stopwatch = Stopwatch.createStarted();
        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i ++) {

        }
        stopwatch.stop();
        long endTime = System.currentTimeMillis();
        System.out.println("stopWatch cost:" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms, currentTimeMillis=" + (endTime - beginTime));
    }

    @Test
    public void middleOrderTraversalTest() {

        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        TreeNode treeNode = TreeNodeFactory.createTreeNode(arr);

        binaryTreeTraversal.middleOrderTraversal(treeNode);

    }

    @Test
    public void postOrderTraversalTest() {

        Integer[][] arr = new Integer[][]{
            {1,2,3,4,5,6}
        };
        for(int i = 0; i < arr.length; i ++) {
            TreeNode treeNode = TreeNodeFactory.createTreeNode(arr[i]);
            binaryTreeTraversal.postOrderTraversal(treeNode);
        }

    }

}
