package com.codefans.interview.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @Author: codefans
 * @Date: 2019-09-24 22:00
 *
 * Runtime: 2 ms, faster than 60.45% of Java online submissions for Valid Parentheses.
 * Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Valid Parentheses.
 *
 */

public class No20ValidParentheses {

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        char top = ' ';
        for(char c : arr) {
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                top = stack.peek();
                if(isOpposite(top, c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpposite(char top, char cur) {
        if(top == '(' && cur == ')') {
            return true;
        }
        if(top == '[' && cur == ']') {
            return true;
        }
        if(top == '{' && cur == '}') {
            return true;
        }
        return false;
    }

}
