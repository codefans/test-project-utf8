package com.codefans.interview.algorithm.leetcode.arrays;


import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

/**
 * No283-移动零-测试类
 *
 * @author: codefans
 * @Date: 2021/10/19 19:28
 * @since: 1.0.0
 */
public class No283MoveZeroesTest {

    @Test
    public void moveZeroesTest() {

        int[][] arr = new int[][]{
            {0,1,0,3,12}
        };
        No283MoveZeroes no283MoveZeroes = new No283MoveZeroes();
        for(int[] data : arr) {
            System.out.println("move before:");
            PrintUtils.printIntArray(data);
            no283MoveZeroes.moveZeroes(data);
            System.out.println("move after:");
            PrintUtils.printIntArray(data);
        }

    }

}