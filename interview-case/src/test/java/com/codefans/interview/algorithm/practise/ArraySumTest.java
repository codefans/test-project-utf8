/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ArraySumTest
 * Author:   caishengzhi
 * Date:     2021/5/29 21:34
 * Description: 数组求和测试类
 */
package com.codefans.interview.algorithm.practise;


import org.junit.Test;

/**
 *
 * 数组求和测试类
 *
 * @author: codefans
 * @Date: 2021/05/29 21:34
 * @since: 1.0.0
 */
public class ArraySumTest {

//    @Test
//    public void arraySumTest() {
//
//
//
//    }

    public static void main(String[] args) {
        ArraySum arraySum = new ArraySum();
        int[] arr = new int[]{-1, 0, 1, -2, -4, 2};
        arraySum.arraySum(arr);
    }

}