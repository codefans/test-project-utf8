package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: codefans
 * @date: 2019-10-08 17:33
 *
 * 与LockCondition2Impl的区别：
 *   实现了：一定先打印字母
 *
 */
public class LockCondition3Impl {

    static volatile boolean t2Start = false;

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

                    while(!t2Start) {
                        condition.await();
                    }

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

                    if(!t2Start) {
                        t2Start = true;
                        condition.signal();
                    }

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
