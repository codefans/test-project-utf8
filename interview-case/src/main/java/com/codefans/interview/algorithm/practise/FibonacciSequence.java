/**
 * Copyright (C), 2015-2021, 京东
 * FileName: FibonacciSequence
 * Author:   caishengzhi
 * Date:     2021/5/13 10:22
 * Description: 斐波那契数列计算类
 */
package com.codefans.interview.algorithm.practise;


/**
 *
 * 斐波那契数列计算类
 *
 * @author: codefans
 * @Date: 2021/05/13 10:22
 * @since: 1.0.0
 */
public class FibonacciSequence {

    /**
     * O(2^n)
     * 有些数字计算多次
     * @param n
     * @return
     */
    public int recursion(int n) {
        return n <= 1 ? n : recursion(n - 1) + recursion(n - 2);
    }

    /**
     * O(n)
     * 优化点：每个数字只计算一次
     * @param n
     * @return
     */
    public int recursionWithCache(int n) {
        return recursionWithCache(n, new int[n + 1]);
    }

    /**
     *
     * @param n
     * @param cacheArr
     * @return
     */
    private int recursionWithCache(int n, int[] cacheArr) {
        if(n <= 1) {
            return n;
        } else if(cacheArr[n] == 0) {
            cacheArr[n] = recursionWithCache(n - 1, cacheArr) + recursionWithCache(n - 2, cacheArr);
        }
        return cacheArr[n];
    }

    /**
     * O(n)
     * 动态规划思想
     * @param n
     * @return
     */
    public int dynamicProgramming(int n) {
        if(n <= 1) {
            return n;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i ++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public int dynamicProgrammingBetter(int n) {
        if(n <= 1) {
            return n;
        }
        int result = 0;
        int a = 0;
        int b = 1;
        for(int i = 2; i <= n; i ++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

}