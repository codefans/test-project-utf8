package com.codefans.interview.algorithm.leetcode.stack;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-09-15 13:06
 */

public class No844BackspaceStringCompareTest {

    String[][] arr;
    No844BackspaceStringCompare no844StrCompare;

    @Before
    public void before() {

        arr = new String[][] {
            {"ab#c","ad#c"},
            {"ab##","c#d#"},
            {"a##c","#a#c"},
            {"y#fo##f","y#f#o##f"},
        };

        no844StrCompare = new No844BackspaceStringCompare();

    }

    @Test
    public void backspaceCompare2Test() {
        long begin = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i ++) {
            System.out.println(no844StrCompare.backspaceCompare2(arr[i][0], arr[i][1]));
        }
        long end = System.currentTimeMillis();
        System.out.println("backspaceCompare2Test cost:[" + (end - begin) + "]ms.");
    }

    @Test
    public void backspaceCompareTest() {
        long begin = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i ++) {
            System.out.println(no844StrCompare.backspaceCompare(arr[i][0], arr[i][1]));
        }
        long end = System.currentTimeMillis();
        System.out.println("backspaceCompare2Test cost:[" + (end - begin) + "]ms.");
    }

}
