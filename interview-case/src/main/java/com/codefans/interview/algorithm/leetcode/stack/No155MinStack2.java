package com.codefans.interview.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @Author: codefans
 * @Date: 2019-09-24 21:47
 */

public class No155MinStack2 {

    private int min;
    private Stack<String> stack;

    /** initialize your data structure here. */
    public No155MinStack2() {
        stack = new Stack<String>();
    }

    public void push(int x) {
        if(stack.size() == 0) {
            min = x;
            stack.push(x+"_"+min);
            //System.out.println(x+"_"+min);
        } else {
            stack.push(x+"_"+min);
            //System.out.println(x+"_"+min);
            if(x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        String top = stack.peek();
        stack.pop();
        min = Integer.parseInt(top.split("_")[1]);

    }

    public int top() {
        return Integer.parseInt(stack.peek().split("_")[0]);
    }

    public int getMin() {
        return min;
    }

}
