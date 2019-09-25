package com.codefans.interview.algorithm.leetcode.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Author: codefans
 * @Date: 2019-09-15 14:25
 */

public class No232ImplementQueueUsingStacks {

    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public No232ImplementQueueUsingStacks() {
        stack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = -1;
        Iterator<Integer> iter = stack.iterator();
        if(iter.hasNext()) {
            res = iter.next();
            iter.remove();
            return res;
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        Iterator<Integer> iter = stack.iterator();
        if(iter.hasNext()) {
            return iter.next();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }

}
