package com.codefans.interview.algorithm.leetcode.arrays;

import java.util.Arrays;

/**
 * @Author: codefans
 * @Date: 2022-04-15 9:47
 */

public class No986IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int[][] res = null;
        int i = 0, j = 0;
        int len1 = firstList.length, len2 = secondList.length;
        int maxLen = len1 >= len2 ? len1 : len2;
        res = new int[len1+len2][2];
        int index = 0;
        while(i < len1 && j < len2) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];
            /**
             * 相交的条件有4种情况，比较复杂，可以通过对不相交条件取反来得到相交的条件；例如：
             * 不相交的条件为：b1 > a2 || a1 > b2，取反：b1 <= a2 && a1 <= b2
             * 所以相交的四种情况可以概况为: b1 <= a2 && a1 <= b2
             */
            //if(b1 > a2 || a1 > b2) {
            if(b1 <= a2 && a1 <= b2) {
                /**
                 * 两个区间相交也有四种情况, 通过画图可以总结为如下实现：
                 */
                res[index][0] = Math.max(a1, b1);
                res[index][1] = Math.min(a2, b2);
                index++;
            }
            if(b2 < a2) {
                j++;
            } else {
                i++;
            }
        }
        res = Arrays.copyOf(res, index);
        return res;
    }

}
