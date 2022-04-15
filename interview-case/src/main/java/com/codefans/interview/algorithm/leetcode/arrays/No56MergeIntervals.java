package com.codefans.interview.algorithm.leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

/**
 * @Author: codefans
 * @Date: 2022-04-14 18:36
 */

public class No56MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][intervals[0].length];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        res[0] = intervals[0];
        int[] last = res[0];

        int[] cur;
        int index = 1;
        for(int i = 1; i < intervals.length; i ++) {
            cur = intervals[i];
            /**
             * 最后一组数据
             */
            last = res[index - 1];
            if(cur[0] <= last[1]) {
                /**
                 * 找到最大的end
                 */
                last[1] = Math.max(cur[1], last[1]);
            } else {
                /**
                 * 处理下一个待合并区间
                 */
                res[index++] = cur;
            }
        }

        res = Arrays.copyOf(res, index);
        return res;
    }
}
