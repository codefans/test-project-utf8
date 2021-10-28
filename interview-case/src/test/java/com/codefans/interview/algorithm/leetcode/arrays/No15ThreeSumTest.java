package com.codefans.interview.algorithm.leetcode.arrays;


import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

import java.util.List;

/**
 * 三数之和测试类
 *
 * @author: codefans
 * @Date: 2021/10/22 11:09
 * @since: 1.0.0
 */
public class No15ThreeSumTest {

    @Test
    public void threeSumTest() {

        int[][] arr = new int[][]{
//            {0,3,0,1,1,-1,-5,-5,3,-3,-3,0}, /* 未考虑到的用例 */
            {14,-11,-2,-3,4,-3,-3,-8,-15,11,11,-6,-14,-13,5,-10,-13,0,-12,-8,14,-12,-10,2,-4,9,13,10,2,7,-2,-7,4,11,5,-7,-15,10,-7,-14,6,11,-5,7,6,8,5,8,-7,8,-15,14,11,13,1,-15,7,0,10,-14,14,-15,-14,3,4,6,4,4,-7,12,5,14,0,8,7,13,1,-11,-2,9,12,-1,8,0,-11,-5,0,11,2,-13,4,1,-12,5,-10,-1,-12,9,-12,-11,-2,9,-12,5,-6,2,4,10,6,-13,4,3,-7,-11,11,-3,-9,-4,-15,8,-9,-4,-13,-14,8,14},
//            {-1,0,1,2,-1,-4},
//            {1,2},
//            {0}
        };
        No15ThreeSum no15ThreeSum = new No15ThreeSum();
        for(int[] data : arr) {
            List<List<Integer>> dataList = no15ThreeSum.threeSum(data);
            PrintUtils.printIntListList(dataList);
            System.out.println();
        }



    }

}