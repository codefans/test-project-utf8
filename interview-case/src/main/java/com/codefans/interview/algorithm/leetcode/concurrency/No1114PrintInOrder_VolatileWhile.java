package com.codefans.interview.algorithm.leetcode.concurrency;

import com.codefans.interview.concurrent.onebyone.RunOneByOneApi;

/**
 * @Author: codefans
 * @Date: 2019-10-14 20:18
 */

public class No1114PrintInOrder_VolatileWhile implements RunOneByOneApi {

    private volatile String yourTurn = "";
    private final String SECOND = "second";
    private final String THIRD = "third";

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        yourTurn = SECOND;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while(!SECOND.equals(yourTurn)) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        yourTurn = THIRD;
    }

    public void third(Runnable printThird) throws InterruptedException {

        while(!THIRD.equals(yourTurn)) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }

}
