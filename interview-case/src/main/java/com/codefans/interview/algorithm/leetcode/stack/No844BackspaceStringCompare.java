package com.codefans.interview.algorithm.leetcode.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Author: codefans
 * @Date: 2019-09-15 12:52
 */

public class No844BackspaceStringCompare {

    /**
     * Runtime: 1 ms, faster than 73.30% of Java online submissions for Backspace String Compare.
     * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Backspace String Compare.
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare2(String S, String T) {
        String ss = minString2(S);
        String tt = minString2(T);
        return ss.equals(tt);
    }

    public String minString2(String str) {

        StringBuilder sb = new StringBuilder();
        char c = ' ';
        for(int i = 0; i < str.length(); i ++) {
            c = str.charAt(i);
            if(sb.length() == 0) {
                if(c != '#') {
                    sb.append(c);
                }
            } else {
                if(c == '#') {
                    sb.deleteCharAt(sb.length()-1);
                } else {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    /**
     * Runtime: 2 ms, faster than 47.85% of Java online submissions for Backspace String Compare.
     * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Backspace String Compare.
     *
     * 没通过的单元测试用例
     *    "y#fo##f"
     *    "y#f#o##f"
     *
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        String ss = minString(S);
        String tt = minString(T);
        return ss.equals(tt);
    }

    public String minString(String str) {
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        char c = ' ';
        for(int i = 0; i < arr.length; i ++) {
            c = arr[i];
            if(stack.isEmpty()) {
                if(c != '#') { //当时没考虑这种情况:如果栈是空的,来一个#字符不能压入栈.
                    stack.push(c);
                }
            } else {
                if(c == '#') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        Iterator<Character> iter = stack.iterator();
        int index = 0;
        while(iter.hasNext()) {
            arr[index++] = iter.next();
        }
        return new String(arr, 0, index);
    }

}
