package com.codefans.interview.algorithm.leetcode.arrays;

import java.util.Arrays;

/**
 * @Author: codefans
 * @Date: 2022-04-14 22:08
 */

public class No1288RemoveCoveredIntervals {

    /**
     * 删除被覆盖区间
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        /**
         * 按照起点升序排序，起点相同则按降序排序；
         */
        Arrays.sort(intervals, (a, b)->{
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        /**
         * 记录合并区间的起点和终点
         */
        int left = intervals[0][0];
        int right = intervals[0][1];
        int len = intervals.length;
        int cover = 0;
        for(int i = 1; i < len; i ++) {
            int[] cur = intervals[i];
            /**
             * 覆盖
             */
            if(left <= cur[0] && cur[1] <= right) {
                cover++;
            }
            /**
             * 相交
             */
            if(cur[0] <= right && right <= cur[1]) {
                right = cur[1];
            }

            /**
             * 分离
             */
            if(cur[0] > right) {
                left = cur[0];
                right = cur[1];
            }
        }
        return len - cover;
    }

}
