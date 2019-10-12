package com.codefans.interview.concurrent.onebyone;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: codefans
 * @Date: 2019-10-09 21:12
 */

public class AtomicIntegerWhileImpl implements RunOneByOneApi {

    public AtomicIntegerWhileImpl() {

    }

    private AtomicInteger order = new AtomicInteger(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        order.set(2);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while(order.get() != 2) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        order.set(3);
    }

    public void third(Runnable printThird) throws InterruptedException {

        while(order.get() != 3) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }

}
