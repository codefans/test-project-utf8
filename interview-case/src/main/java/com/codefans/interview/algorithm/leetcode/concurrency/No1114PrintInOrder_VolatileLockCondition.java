package com.codefans.interview.algorithm.leetcode.concurrency;

import com.codefans.interview.concurrent.onebyone.RunOneByOneApi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: codefans
 * @Date: 2019-10-14 20:32
 */

public class No1114PrintInOrder_VolatileLockCondition implements RunOneByOneApi {

    private volatile String yourTurn = "";
    private final String SECOND = "second";
    private final String THIRD = "third";

    private Lock lock = new ReentrantLock();
    private Condition cdt1 = lock.newCondition();
    private Condition cdt2 = lock.newCondition();

    public void first(Runnable printFirst) throws InterruptedException {

        try {
            lock.lock();

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            yourTurn = SECOND;
            cdt1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        try {

            lock.lock();

            if(!yourTurn.equals(SECOND)) {
                cdt1.await();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            yourTurn = THIRD;
            cdt2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        try {
            lock.lock();

            if(!THIRD.equals(yourTurn)) {
                cdt2.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}
