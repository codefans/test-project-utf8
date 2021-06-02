/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ArrayUtils
 * Author:   caishengzhi
 * Date:     2021/6/1 16:54
 * Description: 数组工具类
 */
package com.codefans.interview.algorithm.common;


/**
 *
 * 数组工具类
 *
 * @author: codefans
 * @Date: 2021/06/01 16:54
 * @since: 1.0.0
 */
public class ArrayUtils {

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void print(int[] arr) {
        if(arr != null) {
            for(int i = 0; i < arr.length; i ++) {
                if(i != 0) {
                    System.out.print(", ");
                }
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }

}