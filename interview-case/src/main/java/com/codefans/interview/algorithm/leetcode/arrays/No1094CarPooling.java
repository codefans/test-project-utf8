package com.codefans.interview.algorithm.leetcode.arrays;

import com.codefans.reusablecode.datastructure.DiffArray;

/**
 * No1094 拼车
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 * @Author: codefans
 * @Date: 2022-04-20 0:10
 */

public class No1094CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {

        int[] arr = new int[1001];
        DiffArray diffArray = new DiffArray(arr);
        for(int i = 0; i < trips.length; i ++) {
            diffArray.inc(trips[i][1], trips[i][2] - 1, trips[i][0]);
        }
        int[] resArr = diffArray.result();
        boolean res = true;
        for(int i = 0; i < resArr.length; i ++) {
            if(resArr[i] > capacity) {
                res = false;
                break;
            }
        }
        return res;
    }


}
