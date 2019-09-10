package com.codefans.interview.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author: codefans
 * @date: 2019-09-05 20:49
 */
public class No1021RemoveOutermostParentheses {

    /**
     * Runtime: 7 ms, faster than 34.82% of Java online submissions for Remove Outermost Parentheses.
     * Memory Usage: 37.5 MB, less than 31.17% of Java online submissions for Remove Outermost Parentheses.
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        char[] parentheses = S.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        char topC = ' ';
        for(int i = 0; i < parentheses.length; i ++) {
            c = parentheses[i];
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(c == '(') {
                    stack.push(c);
                    sb.append("(");
                } else {

                    topC = stack.peek();
                    if(topC == '(' && stack.size() == 1) {
                        stack.pop();
                    } else {
                        sb.append(")");
                        stack.pop();
                    }

                }

            }

        }
        return sb.toString();
    }

    /**
     * Runtime: 6 ms, faster than 38.86% of Java online submissions for Remove Outermost Parentheses.
     * Memory Usage: 37.1 MB, less than 93.51% of Java online submissions for Remove Outermost Parentheses.
     *
     * 思路
     *    (1) 如果栈为空,直接将字符放入栈中;
     *    (2) 如果栈不为空,且当前字符为左括号(, 则将字符放入栈和结果字符串中;
     *    (3)         如果当前字符串为右括号), 且栈大小为1, 则直接将栈的元素移除;
     *    (4)         如果当前字符串为右括号), 且栈大小不为1, 则将栈的元素移除,且将当前字符放入结果字符串中;
     * @param S
     * @return
     */
    public String removeOuterParentheses2(String S) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        char topC = ' ';
        for(int i = 0; i < S.length(); i ++) {
            c = S.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(c == '(') {
                    stack.push(c);
                    sb.append(c);
                } else {
                    if(c == ')' && stack.size() == 1) {
                        stack.pop();
                    } else {
                        stack.pop();
                        sb.append(")");
                    }
                }
            }
        }
        return sb.toString();

    }

    /**
     * Runtime: 3 ms, faster than 68.06% of Java online submissions for Remove Outermost Parentheses.
     * Memory Usage: 37.2 MB, less than 93.51% of Java online submissions for Remove Outermost Parentheses.
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses3(String S) {
        int charCount = 0;
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        char topC = ' ';
        for(int i = 0; i < S.length(); i ++) {
            c = S.charAt(i);
            if(charCount == 0) {
                charCount++;
            } else {
                if(c == '(') {
                    charCount++;
                    sb.append(c);
                } else {
                    if(c == ')' && charCount == 1) {
                        charCount--;
                    } else {
                        charCount--;
                        sb.append(")");
                    }
                }
            }
        }
        return sb.toString();

    }

}
