/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ArrayMergeTest
 * Author:   caishengzhi
 * Date:     2021/6/2 17:03
 * Description: 数组合并测试类
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 数组合并测试类
 *
 * @author: codefans
 * @Date: 2021/06/02 17:03
 * @since: 1.0.0
 */
public class ArrayMergeTest {

    /**
     *
     */
    private ArrayMerge arrayMerge;

    @Before
    public void before() {
        arrayMerge = new ArrayMerge();
    }

    @Test
    public void mergeSortedArrayTest() {

//        int[] arr1 = new int[]{1,3,5,7,9};
//        int[] arr2 = new int[]{0,2,4,6,8,10};
//        int[] arr1 = new int[]{1,3,5,};
//        int[] arr2 = new int[]{0,2,4,6,8,10};
        int[] arr1 = new int[]{1,3,5,7,9};
        int[] arr2 = new int[]{0,2,4};
        int[] resultArr = arrayMerge.mergeSortedArray(arr1, arr2);
        ArrayUtils.print(resultArr);
    }
}