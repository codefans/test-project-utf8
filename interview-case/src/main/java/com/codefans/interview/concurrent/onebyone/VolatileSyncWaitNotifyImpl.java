package com.codefans.interview.concurrent.onebyone;

/**
 * @author: codefans
 * @date: 2019-10-12 17:41
 */
public class VolatileSyncWaitNotifyImpl implements RunOneByOneApi {

    private Object lock = new Object();
    private Object lock2 = new Object();

    private volatile int state = 0;

    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            state = 1;
            lock.notify();
        }
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            if(state != 1) {
                lock.wait();
            }
            printSecond.run();
            state = 2;
            synchronized (lock2) {
                lock2.notify();
            }
        }
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock2) {
            if(state != 2) {
                lock2.wait();
            }
            printThird.run();
        }
    }
}
