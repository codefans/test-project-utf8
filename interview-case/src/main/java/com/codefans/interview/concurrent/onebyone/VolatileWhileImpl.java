package com.codefans.interview.concurrent.onebyone;

/**
 * @Author: codefans
 * @Date: 2019-10-09 21:10
 */

public class VolatileWhileImpl implements RunOneByOneApi {

    public VolatileWhileImpl() {

    }

    private volatile String yourTurn = "first";
    private final String SECOND = "second";
    private final String THIRD = "third";

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        yourTurn = SECOND;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while(!yourTurn.equals(SECOND)) {}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        yourTurn = THIRD;
    }

    public void third(Runnable printThird) throws InterruptedException {

        while(!yourTurn.equals(THIRD)) {}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }

}
