package com.codefans.interview.algorithm.offer;

import com.codefans.interview.algorithm.common.TreeNode;
import com.codefans.interview.algorithm.common.TreeNodeFactory;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2021-09-20 10:31
 */

public class BinaryTreeSerializeTest {

    @Test
    public void serializeTest() {

        Integer[][] arr = new Integer[][]{
//            {1},
//            {1,2},
            {1,null,3},
//            {1,2,3},
            {1,2,3,null,4},
            {1,2,3,null,4,5,6}
        };
        BinaryTreeSerialize treeSerialize = new BinaryTreeSerialize();
        for(int i = 0; i < arr.length; i ++) {
            TreeNode treeNode = TreeNodeFactory.createTreeNode(arr[i]);
            String serializeStr = treeSerialize.serialize(treeNode);
            System.out.println("序列化字符串:");
            System.out.println(serializeStr);

            TreeNode deSerializeTreeNode = treeSerialize.deserialize(serializeStr);
            System.out.println("二叉树反序列化输出:");
            TreeNodeFactory.printByLevel(deSerializeTreeNode);

        }

    }

}
