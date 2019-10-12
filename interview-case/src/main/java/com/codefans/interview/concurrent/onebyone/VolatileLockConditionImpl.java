package com.codefans.interview.concurrent.onebyone;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: codefans
 * @date: 2019-10-11 17:36
 */
public class VolatileLockConditionImpl implements RunOneByOneApi {

    private ReentrantLock lock = new ReentrantLock();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    private volatile int state = 0;

    @Override
    public void first(Runnable printFirst) throws InterruptedException {

        try {
            lock.lock();

            printFirst.run();

            state = 1;
            c2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {

        try {
            lock.lock();

            if(state != 1) {
                c2.await();
            }

            printSecond.run();

            state = 2;
            c3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {

        try {
            lock.lock();

            if(state != 2) {
                c3.await();
            }
            printThird.run();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
