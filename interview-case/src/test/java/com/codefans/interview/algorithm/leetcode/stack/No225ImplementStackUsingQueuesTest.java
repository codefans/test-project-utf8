package com.codefans.interview.algorithm.leetcode.stack;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-09-18 22:46
 */

public class No225ImplementStackUsingQueuesTest {

    private No225ImplementStackUsingQueues implStackUsingQueue;

    @Before
    public void before() {
        implStackUsingQueue = new No225ImplementStackUsingQueues();
    }

    @Test
    public void test() {

        implStackUsingQueue.push(1);
        implStackUsingQueue.push(2);
        int top = implStackUsingQueue.top();   // returns 2
        int pop = implStackUsingQueue.pop();   // returns 2
        System.out.println("top:" + top);
        System.out.println("pop:" + pop);

        boolean isEmpty = implStackUsingQueue.empty(); // returns false
        System.out.println("isEmpty:" + isEmpty);

    }

}
