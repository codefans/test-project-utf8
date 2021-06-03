/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ArraySorterTest
 * Author:   caishengzhi
 * Date:     2021/6/1 16:40
 * Description: 数组排序测试类
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 数组排序测试类
 *
 * @author: codefans
 * @Date: 2021/06/01 16:40
 * @since: 1.0.0
 */
public class ArraySorterTest {

    /**
     * 数组排序
     */
    private ArraySorter arraySorter;

    @Before
    public void before() {
        arraySorter = new ArraySorter();
    }

    @Test
    public void bubbleSortTest() {
        int[][] arr = new int[][] {
                {1,3,2,5,7,4,6,8},
                {3,3,2,5,7,4,6,2},
                {8,3,2,5,7,4,6,1},
                {1,8,2,5,7,4,6,3}
        };
        for(int i = 0; i < arr.length; i ++) {
            arraySorter.bubbleSort(arr[i]);
            ArrayUtils.print(arr[i]);
        }
    }

    @Test
    public void selectSortTest() {
        int[][] arr = new int[][] {
                {1,3,2,5,7,4,6,8},
                {3,3,2,5,7,4,6,2},
                {8,3,2,5,7,4,6,1},
                {1,8,2,5,7,4,6,3}
        };
        for(int i = 0; i < arr.length; i ++) {
//            arraySorter.selectSort(arr);
            arraySorter.selectSortOpti(arr[i]);
            ArrayUtils.print(arr[i]);
        }
    }

    @Test
    public void insertSortTest() {
        int[][] arr = new int[][] {
                {1,3,2,5,7,4,6,8},
                {3,3,2,5,7,4,6,2},
                {8,3,2,5,7,4,6,1},
                {1,8,2,5,7,4,6,3}
        };
        for(int i = 0; i < arr.length; i ++) {
            arraySorter.insertSort(arr[i]);
            ArrayUtils.print(arr[i]);
        }
    }

    @Test
    public void shellSortTest() {
        int[][] arr = new int[][] {
                {1,3,2,5,7,4,6,8},
                {3,3,2,5,7,4,6,2},
                {8,3,2,5,7,4,6,1},
                {1,8,2,5,7,4,6,3}
        };
        for(int i = 0; i < arr.length; i ++) {
            arraySorter.shellSort(arr[i]);
            ArrayUtils.print(arr[i]);
        }
    }

    @Test
    public void quickSortTest() {
        int[][] arr = new int[][] {
                {1,3,2,5,7,4,6,8},
                {3,3,2,5,7,4,6,2},
                {8,3,2,5,7,4,6,1},
                {1,8,2,5,7,4,6,3}
        };
        for(int i = 0; i < arr.length; i ++) {
            arraySorter.quickSort(arr[i]);
            ArrayUtils.print(arr[i]);
        }

    }

    @Test
    public void mergeSortTest() {

        int[][] arr = new int[][] {
                {1,3,2,5,7,4,6,8},
                {3,3,2,5,7,4,6,2},
                {8,3,2,5,7,4,6,1},
                {1,8,2,5,7,4,6,3}
        };
        for(int i = 0; i < arr.length; i ++) {
            arraySorter.mergeSort(arr[i]);
            ArrayUtils.print(arr[i]);
        }
    }

    @Test
    public void heapSortTest() {
        int[][] arr = new int[][] {
            {1,3,2,5,7,4,6,8},
            {3,3,2,5,7,4,6,2},
            {8,3,2,5,7,4,6,1},
            {1,8,2,5,7,4,6,3}
        };
        for(int i = 0; i < arr.length; i ++) {
            arraySorter.heapSort(arr[i]);
            ArrayUtils.print(arr[i]);
        }
    }

}