package com.codefans.interview.algorithm.leetcode.concurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: codefans
 * @Date: 2019-10-14 20:48
 */

public class No1114PrintInOrder_VolatileLockSupport {

    private volatile String yourTurn = "";
    private final String SECOND = "second";
    private final String THIRD = "third";

    private volatile Thread t2;
    private volatile Thread t3;

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        yourTurn = SECOND;

        if(t2 != null) {
            LockSupport.unpark(t2);
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        t2 = Thread.currentThread();

        if(!yourTurn.equals(SECOND)) {
            LockSupport.park();
        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        yourTurn = THIRD;
        if(t3 != null) {
            LockSupport.unpark(t3);
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        t3 = Thread.currentThread();

        if(!THIRD.equals(yourTurn)) {
            LockSupport.park();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();


    }

}
