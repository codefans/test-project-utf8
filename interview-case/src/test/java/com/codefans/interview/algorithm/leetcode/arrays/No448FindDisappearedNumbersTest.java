package com.codefans.interview.algorithm.leetcode.arrays;


import com.codefans.reusablecode.util.StringUtils;
import org.junit.Test;

import java.util.List;

/**
 * 找到数组中消失的数字测试类
 *
 * @author: codefans
 * @Date: 2021/10/20 10:05
 * @since: 1.0.0
 */
public class No448FindDisappearedNumbersTest {

    @Test
    public void findDisappearedNumbersTest() {
        int[][] arr = new int[][]{
            {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,32},
            {4,3,2,7,8,2,3,1},
            {1,1}
        };
        No448FindDisappearedNumbers no448FindDisappearedNumbers = new No448FindDisappearedNumbers();
        for(int[] data : arr) {
            List<Integer> dataList = no448FindDisappearedNumbers.findDisappearedNumbers(data);
            System.out.println("data:[" + StringUtils.toString(data) + "], dispearedNumbers:[" + StringUtils.toString(dataList) + "]");
        }
    }

}