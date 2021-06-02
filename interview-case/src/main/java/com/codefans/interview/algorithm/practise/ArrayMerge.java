/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ArrayMerge
 * Author:   caishengzhi
 * Date:     2021/6/2 16:55
 * Description: 数组合并
 */
package com.codefans.interview.algorithm.practise;


/**
 *
 * 数组合并
 *
 * @author: codefans
 * @Date: 2021/06/02 16:55
 * @since: 1.0.0
 */
public class ArrayMerge {

    /**
     * 两个有序数组的合并
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] mergeSortedArray(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null) {
            return arr1 == null ? arr2 : arr1;
        }
        int i = 0, j = 0, index = 0;
        int len1 = arr1.length, len2 = arr2.length;
        int[] resultArr = new int[len1 + len2];
        while(i < len1 && j < len2) {
            if(arr1[i] < arr2[j]) {
                resultArr[index++] = arr1[i++];
            } else {
                resultArr[index++] = arr2[j++];
            }
        }
        while(i < len1) {
            resultArr[index++] = arr1[i++];
        }
        while(j < len2) {
            resultArr[index++] = arr2[j++];
        }
        return resultArr;
    }
}