/**
 * Copyright (C), 2015-2021, 京东
 * FileName: BinaryTreeSubStructureTest
 * Author:   codefans
 * Date:     2021/9/15 10:51
 * Description: 判断是否是二叉树的子结构
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.TreeNode;
import com.codefans.interview.algorithm.common.TreeNodeFactory;
import org.junit.Test;

/**
 *
 * 判断是否是二叉树的子结构
 *
 * @author: codefans
 * @Date: 2021/09/15 10:51
 * @since: 1.0.0
 */
public class BinaryTreeSubStructureTest {

    /**
     * 示例 1：
     *    输入：A = [1,2,3], B = [3,1]
     *    输出：false
     * 示例 2：
     *    输入：A = [3,4,5,1,2], B = [4,1]
     *    输出：true
     */
    @Test
    public void isSubStructureTest() {

//        Integer[] aArr = new Integer[]{1,2,3};
//        Integer[] bArr = new Integer[]{3,1};
        Integer[] aArr = new Integer[]{3,4,5,1,2};
        Integer[] bArr = new Integer[]{4,1};
        TreeNode a = TreeNodeFactory.createTreeNode(aArr);
        TreeNode b = TreeNodeFactory.createTreeNode(bArr);
        BinaryTreeSubStructure binaryTreeSubStructure = new BinaryTreeSubStructure();
        boolean isSubStructure = binaryTreeSubStructure.isSubStructure(a, b);
        System.out.println("isSubStructure=" + isSubStructure);

    }

}