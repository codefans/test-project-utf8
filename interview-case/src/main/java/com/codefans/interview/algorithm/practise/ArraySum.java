/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ArraySum
 * Author:   codefans
 * Date:     2021/5/29 21:31
 * Description: 数组求和
 */
package com.codefans.interview.algorithm.practise;


/**
 *
 * 数组求和
 *
 * @author: codefans
 * @Date: 2021/05/29 21:31
 * @since: 1.0.0
 */
public class ArraySum {

    public void arraySum(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for(int i = 0; i < len; i ++) {
            for(int j = 0; j < len; j ++) {
                for (int k = 0; k < len; k++) {
                    if (arr[i] + arr[j] + arr[k] == sum) {
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                    }
                }
            }
        }
    }

    public void arraySum2(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for(int i = 0, j = len - 1; i < len && j >= 0; i ++, j --) {
            for(int k = 0; k < len; k ++) {
                if(arr[i] + arr[j] + arr[k] == sum) {
                    System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                }
            }
        }
    }

}
