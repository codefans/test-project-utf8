package com.codefans.interview.concurrent.onebyone;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: codefans
 * @date: 2019-10-12 17:50
 */
public class VolatileLockSupportImpl implements RunOneByOneApi {

    private volatile int state = 0;

    private volatile Thread t1;
    private volatile Thread t2;
    private volatile Thread t3;

    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        t1 = Thread.currentThread();
        printFirst.run();
        state = 1;
        LockSupport.unpark(t2);
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        t2 = Thread.currentThread();
        if(state != 1) {
            LockSupport.park();
        }
        printSecond.run();
        state = 2;
        LockSupport.unpark(t3);
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        t3 = Thread.currentThread();
        if(state != 2) {
            LockSupport.park();
        }
        printThird.run();
    }
}
