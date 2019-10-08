package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.CountDownLatch;

/**
 * @author: codefans
 * @date: 2019-10-08 17:14
 *
 * 与SyncWaitNotifyImpl的区别：
 *     该类实现了：一定先打印字母
 *
 * 可以2种方法实现：
 *    (1)用一个volatile变量；
 *    (2)使用CountDownLatch
 *
 */
public class SyncWaitNotify2Impl {

    static volatile boolean t2Start = false;

    public static void main(String[] args) {

        char[] aI = "1234567890".toCharArray();
        char[] aC = "ABCDEFGHIJ".toCharArray();

        Object lock = new Object();

        /**
         * 如果需要先打印字母, 则可以使用CountDownLatch
         */
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock) {
                    //方法(1)
                    while (!t2Start) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    /**
                     * 如果需要先打印字母, 需要把下面这部分代码打开
                     */
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                    for (char c : aI) {

                        try {
                            lock.notify();
                            lock.wait();

                            System.out.print(c);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();

                    }
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                //方法(1)
                t2Start = true;

                /**
                 * 如果需要先打印字母, 需要把下面这部分代码打开
                 */
//                countDownLatch.countDown();



                for(char c : aC) {
                    synchronized (lock) {
                        try {
                            lock.notify();
                            lock.wait();

                            System.out.print(c);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock.notify();
                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();

    }

}
