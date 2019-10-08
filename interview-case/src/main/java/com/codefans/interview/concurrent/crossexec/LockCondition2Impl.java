package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: codefans
 * @date: 2019-10-08 17:23
 *
 * 与LockConditionImpl的区别：
 *    使用两个Condition
 *
 */
public class LockCondition2Impl {

    public static void main(String[] args) {

        char[] aI = "1234567890".toCharArray();
        char[] aC = "ABCDEFGHIJ".toCharArray();

        Lock lock = new ReentrantLock();
        Condition conditionL1 = lock.newCondition();
        Condition conditionL2 = lock.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    lock.lock();

                    for(char c : aI) {

                        conditionL1.signal();
                        conditionL2.await();

                        System.out.print(c);

                        conditionL1.signal();
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

                        conditionL2.signal();
                        conditionL1.await();

                        System.out.print(c);

                        conditionL2.signal();
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
