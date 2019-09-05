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

}
