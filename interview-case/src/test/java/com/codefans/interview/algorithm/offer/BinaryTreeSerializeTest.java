package com.codefans.interview.algorithm.offer;

import com.codefans.reusablecode.util.ArrayUtils;
import com.codefans.reusablecode.datastructure.TreeNode;
import com.codefans.reusablecode.datastructure.TreeNodeFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        int[] dataArr = new int[10];
        dataArr[0] = 1;
        dataArr[1] = 2;
        dataArr[2] = 3;
        int[] newArr = new int[3];
        System.arraycopy(dataArr, 0, newArr, 0, 3);
//        System.out.println(newArr);
        ArrayUtils.print(newArr);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


    }

}
