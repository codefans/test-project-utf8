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

    @Test
    public void mergeSortedArrayTest2() {

        int[] arr1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] arr2 = new int[]{2,5,6};
        int n = 3;
        arrayMerge.mergeSortedArray(arr1, m, arr2, n);
        ArrayUtils.print(arr1);

        arr1 = new int[]{1};
        m = 1;
        arr2 = new int[]{};
        n = 0;
        arrayMerge.mergeSortedArray(arr1, m, arr2, n);
        ArrayUtils.print(arr1);

        arr1 = new int[]{0};
        m = 0;
        arr2 = new int[]{1};
        n = 1;
        arrayMerge.mergeSortedArray(arr1, m, arr2, n);
        ArrayUtils.print(arr1);

        arr1 = new int[]{0,0,0,0,0};
        m = 0;
        arr2 = new int[]{1,2,3,4,5};
        n = 5;
        arrayMerge.mergeSortedArray(arr1, m, arr2, n);
        ArrayUtils.print(arr1);

    }
}