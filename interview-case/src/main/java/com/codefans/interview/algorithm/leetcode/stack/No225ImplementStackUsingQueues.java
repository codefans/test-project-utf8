package com.codefans.interview.algorithm.leetcode.stack;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: codefans
 * @Date: 2019-09-18 22:45
 *
 * 思路
 *    队列是先进先出
 *    栈是后进先出
 *
 *    入栈：queue.put
 *    出栈：queue.toArray(new Integer(0))[queue.size()-1];
 *
 */

public class No225ImplementStackUsingQueues {

    /**
     * Runtime: 44 ms, faster than 10.86% of Java online submissions for Implement Stack using Queues.
     * Memory Usage: 34 MB, less than 91.67% of Java online submissions for Implement Stack using Queues.
     */
//    private ArrayBlockingQueue<Integer> queue;

    /**
     * Runtime: 42 ms, faster than 78.88% of Java online submissions for Implement Stack using Queues.
     * Memory Usage: 34.2 MB, less than 91.67% of Java online submissions for Implement Stack using Queues.
     *
     */
//    private LinkedBlockingQueue<Integer> queue;

    /**
     * Runtime: 42 ms, faster than 78.88% of Java online submissions for Implement Stack using Queues.
     * Memory Usage: 33.8 MB, less than 91.67% of Java online submissions for Implement Stack using Queues.
     */
//    private ConcurrentLinkedQueue<Integer> queue;


    private PriorityQueue<Integer> queue;

    /** Initialize your data structure here. */
    public No225ImplementStackUsingQueues() {
//        queue = new ArrayBlockingQueue<Integer>(10);
//        queue = new LinkedBlockingQueue<Integer>(10);
//        queue = new ConcurrentLinkedQueue<Integer>();
        queue = new PriorityQueue<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
//        try {
//            queue.put(x);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //for ConcurrentLinkedQueue
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = queue.toArray(new Integer[0])[queue.size()-1];
        queue.remove(res);
        return res;
    }

    /** Get the top element. */
    public int top() {
        return queue.toArray(new Integer[0])[queue.size() - 1];
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
