package com.codefans.interview.algorithm.leetcode.arrays;


import org.junit.Test;

/**
 * 多数元素测试类
 *
 * @author: * @Date: 2021/10/12 10:31
 * @since: 1.0.0
 */
public class No169MajorityElementTest {

    /**
     * 示例1：
     * 输入：[3,2,3]
     * 输出：3
     *
     * 示例2：
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     */
    @Test
    public void majorityElementTest() {

        No169MajorityElement majorityElement = new No169MajorityElement();
        int[] arr = new int[]{3,2,3};
        int majority = majorityElement.majorityElement(arr);
        System.out.println("majorityElement=" + majority);

        arr = new int[]{2,2,1,1,1,2,2};
        majority = majorityElement.majorityElement(arr);
        System.out.println("majorityElement=" + majority);



    }

}