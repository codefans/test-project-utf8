/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ClimbingStairsTest
 * Author:   codefans
 * Date:     2021/9/24 14:08
 * Description: 爬楼梯测试类
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.offer.ClimbingStairs;
import org.junit.Test;

/**
 *
 * 爬楼梯测试类
 *
 * @author: codefans
 * @Date: 2021/09/24 14:08
 * @since: 1.0.0
 */
public class ClimbingStairsTest {

    /**
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     *
     * 示例 2：
     * 输入：n = 7
     * 输出：21
     *
     * 示例 3：
     * 输入：n = 0
     * 输出：1
     *
     * 输入：n = 44
     * 输出：1134903170
     */
    @Test
    public void climbingStairsTest() {

        int[] arr = new int[]{
            0,1,2,3,4,5,6,7,8,9,10,11,44
        };
        ClimbingStairs climbingStairs = new ClimbingStairs();
        for(int n : arr) {
            int result = climbingStairs.climbStairs(n);
            System.out.println("n=" + n + ", climbingStairs=" + result);
        }
    }
}