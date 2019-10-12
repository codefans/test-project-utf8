package com.codefans.interview.concurrent.onebyone;

import java.util.concurrent.CountDownLatch;

/**
 * @author: codefans
 * @date: 2019-10-12 17:15
 */
public class CountDownLatchImpl implements RunOneByOneApi {

    private CountDownLatch latch2 = new CountDownLatch(1);
    private CountDownLatch latch3 = new CountDownLatch(1);

    @Override
    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        latch2.countDown();
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {

        latch2.await();
        printSecond.run();
        latch3.countDown();

    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {

        latch3.await();
        printThird.run();

    }
}
