/**
 * Copyright (C), 2015-2021, 京东
 * FileName: RepeatPermutation
 * Author:   caishengzhi
 * Date:     2021/9/27 10:16
 * Description: 有重复字符的排列
 */
package com.codefans.interview.algorithm.leetcode.strings;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 有重复字符的排列
 *
 * @author: codefans
 * @Date: 2021/09/27 10:16
 * @since: 1.0.0
 */
public class RepeatPermutation {

    private List<String> list;

    public String[] permutation(String source) {
        if(source == null) {
            return null;
        }
        list = new ArrayList<>();
        this.permutation(source.toCharArray(), 0);
        return list.toArray(new String[0]);
    }

    private void permutation(char[] arr, int first) {
        if(first == arr.length - 1) {
            list.add(new String(arr));
        }
        for(int i = first; i < arr.length; i ++) {
            if(notSame(arr, first, i)) {
                swap(arr, first, i);
                permutation(arr, first + 1);
                swap(arr, first, i);
            }
        }
    }

    /**
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private boolean notSame(char[] arr, int i, int j) {
//        return arr[i] != arr[j];
        for(int m = i; m < j; m ++) {
            if(arr[m] == arr[j]) {
                return false;
            }
        }
        return true;
    }
    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

}