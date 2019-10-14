package com.codefans.interview.algorithm.leetcode.concurrency;

import com.codefans.interview.concurrent.onebyone.RunOneByOneApi;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: codefans
 * @Date: 2019-10-14 21:14
 */

public class No1114PrintInOrder_CountDownLatch implements RunOneByOneApi {

    private CountDownLatch latch1 = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown();


    }

    public void second(Runnable printSecond) throws InterruptedException {

        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch2.countDown();


    }

    public void third(Runnable printThird) throws InterruptedException {

        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();


    }

}
