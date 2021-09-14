/**
 * Copyright (C), 2015-2021, 京东
 * FileName: PostorderTraversalOfBinaryTreeTest
 * Author:   caishengzhi
 * Date:     2021/9/13 16:22
 * Description: 判断数据是否是二叉树的后序遍历测试类
 */
package com.codefans.interview.algorithm.offer;


import org.junit.Test;

/**
 *
 * 判断数据是否是二叉树的后序遍历测试类
 *
 * @author: codefans
 * @Date: 2021/09/13 16:22
 * @since: 1.0.0
 */
public class PostorderTraversalOfBinaryTreeTest {

    @Test
    public void verifyPostorderTest() {


        PostorderTraversalOfBinaryTree postorderTraversalOfBinaryTree = new PostorderTraversalOfBinaryTree();
        int[][] postOrderArr = new int[][] {
            {1,6,3,2,5}, //false
            {1,3,2,6,5}, //true
            {7,4,6,5}, //false
            {4, 8, 6, 12, 16, 14, 10},  //true
            {1,2,5,10,6,9,4,3},  //false
            {},  //true
            {5, 7, 6, 9, 11, 10, 8}  //true
        };
        for(int i = 0; i < postOrderArr.length; i ++) {
            boolean isPostOrder = postorderTraversalOfBinaryTree.verifyPostorder(postOrderArr[i]);
            System.out.println("isPostOrder=" + isPostOrder);
        }


    }

}