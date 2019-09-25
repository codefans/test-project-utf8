package com.codefans.interview.algorithm.leetcode.stack;

import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-09-24 22:00
 */

public class No20ValidParenthesesTest {

    @Test
    public void validParenthesesTest() {

        String[] arr = new String[] {
            "()",
            "()[]{}",
            "(]",
            "([)]",
        };
        No20ValidParentheses no20ValidParentheses = new No20ValidParentheses();
        for(String str : arr) {
            if(str != null && str.trim().length() > 0) {
                System.out.println(str + ": " + no20ValidParentheses.isValid(str));
            }
        }

    }

}
