package com.codefans.interview.algorithm.leetcode.stack;

import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-09-15 14:26
 */

public class No232ImplementQueueUsingStacksTest {

    @Test
    public void implQueueUsingStackTest() {

        No232ImplementQueueUsingStacks myQueue = new No232ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);
        int top = myQueue.peek();  // returns 1
        System.out.println("peek:" + top);
        top = myQueue.pop();   // returns 1
        System.out.println("pop:" + top);
        boolean isEmpty = myQueue.empty(); // returns false
        System.out.println("isEmpty:" + isEmpty);

    }

}
