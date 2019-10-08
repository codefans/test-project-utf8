package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: codefans
 * @date: 2019-10-08 17:23
 */
public class LockConditionImpl {

    public static void main(String[] args) {

        char[] aI = "1234567890".toCharArray();
        char[] aC = "ABCDEFGHIJ".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lock();

                    for(char c : aI) {

                        condition.signal();
                        condition.await();

                        System.out.print(c);

                        condition.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lock();

                    for(char c : aC) {

                        condition.signal();
                        condition.await();

                        System.out.print(c);

                        condition.signal();
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }, "t2");

        t1.start();
        t2.start();

    }

}
