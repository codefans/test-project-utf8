package com.codefans.reusablecode.datastructure;

/**
 * 差分数组工具类
 * @Author: codefans
 * @Date: 2022-04-20 0:11
 */

public class DiffArray {
    int[] arr;
    int[] diff;
    public DiffArray(int[] arr) {
        this.arr = arr;
        diff = new int[arr.length];
        diff[0] = arr[0];
        for(int i = 1; i < arr.length; i ++) {
            diff[i] = arr[i] - arr[i-1];
        }
    }

    public void inc(int i, int j, int incVal) {
        diff[i] += incVal;
        if(j + 1 < diff.length) {
            diff[j + 1] -= incVal;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for(int i = 1; i < res.length; i ++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}
