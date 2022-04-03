/**
 * Copyright (C), 2015-2021, 京东
 * FileName: FibonacciSequenceTest
 * Author:   codefans
 * Date:     2021/5/13 10:32
 * Description: 斐波那契数列方法测试
 */
package com.codefans.interview.algorithm.practise;


import org.junit.Before;
import org.junit.Test;

/**
 *
 * 斐波那契数列方法测试
 *
 * @author: codefans
 * @Date: 2021/05/13 10:32
 * @since: 1.0.0
 */
public class FibonacciSequenceTest {

    /**
     *
     */
    FibonacciSequence fibonacciSequence;

    @Before
    public void before() {
        fibonacciSequence = new FibonacciSequence();
    }

    @Test
    public void recursionTest() {
        int n = 10;
        System.out.println("斐波那契数列-递归解法：");
        for(int i = 0; i < n; i ++) {
            System.out.print(fibonacciSequence.recursion(i) + ",");
        }
    }

    @Test
    public void recursionWithCacheTest() {
        int n = 10;
        System.out.println("斐波那契数列-递归加缓存解法：");
        for(int i = 0; i < n; i ++) {
            System.out.print(fibonacciSequence.recursionWithCache(i) + ",");
        }
    }

    @Test
    public void dynamicProgrammingTest() {
        int n = 10;
        System.out.println("斐波那契数列-动态规划解法：");
        for(int i = 0; i < n; i ++) {
            System.out.print(fibonacciSequence.dynamicProgramming(i) + ",");
        }
    }

    @Test
    public void dynamicProgrammingBetterTest() {
        int n = 44;
        System.out.println("斐波那契数列-动态规划解法：");
        for(int i = 0; i < n; i ++) {
            System.out.print(fibonacciSequence.dynamicProgrammingBetter(i) + ",");
        }
    }

}