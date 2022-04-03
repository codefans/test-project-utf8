/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ClimbingStairs
 * Author:   caishengzhi
 * Date:     2021/9/24 14:07
 * Description: 爬楼梯问题
 */
package com.codefans.interview.algorithm.offer;


/**
 *
 * 爬楼梯问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 * @author: codefans
 * @Date: 2021/09/24 14:07
 * @since: 1.0.0
 */
public class ClimbingStairs {

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
     *
     * 70. 爬楼梯
     * https://leetcode-cn.com/problems/climbing-stairs/
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int result = 0;
        if(n <= 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        for(int i = 2; i <= n; i ++) {
            /**
             * 70.爬楼梯：不需要除以1000000007
             * 剑指Offer青蛙跳台阶问题：需要除以1000000007
             */
            result = (a + b) % 1000000007;
//            if((a + b) >= 1000000007) {
//                System.out.println("a+b=" + (a+b) + ", result=" + result);
//            }
            b = a;
            a = result;
        }
        return result;
    }

}
