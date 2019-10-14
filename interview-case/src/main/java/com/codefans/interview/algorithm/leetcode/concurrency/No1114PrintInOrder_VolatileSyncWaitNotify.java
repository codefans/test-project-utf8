package com.codefans.interview.algorithm.leetcode.concurrency;

import com.codefans.interview.concurrent.onebyone.RunOneByOneApi;

/**
 * @Author: codefans
 * @Date: 2019-10-14 20:22
 */

public class No1114PrintInOrder_VolatileSyncWaitNotify implements RunOneByOneApi {

    private volatile String yourTurn = "";
    private final String SECOND = "second";
    private final String THIRD = "third";

    //private AtomicInteger order = new AtomicInteger(1);

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized(lock1) {


            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            yourTurn = SECOND;
            lock1.notify();

        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized(lock1) {

            if(!yourTurn.equals(SECOND)) {
                lock1.wait();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            yourTurn = THIRD;
            synchronized(lock2) {
                lock2.notify();
            }
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized(lock2) {
            if(!THIRD.equals(yourTurn)) {
                lock2.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }


    }

}
