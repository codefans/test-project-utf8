/**
 * Copyright (C), 2015-2020, 京东
 * FileName: ThreadStateTest
 * Author:   codefans
 * Date:     2020/10/6 15:57
 * Description: 线程状态测试
 */
package com.codefans.basicjava.concurrent.thread;

/**
 *
 * 线程状态测试
 *
 * @author codefans
 * @date 2020/10/06 15:57
 * @since 1.0.0
 */
public class ThreadStateTest {

    public static void main(String[] args) {
        ThreadStateTest threadStateTest = new ThreadStateTest();
        threadStateTest.startup();
    }

    public void startup() {

        this.newStateTest();
        this.runnableStateTest();
        this.blockedStateTest();
        this.waitingStateTest();
        this.timedWaitingStateTest();
        this.terminatedStateTest();


    }

    public void newStateTest() {
        Thread t = new Thread("newStateTesting");
        System.out.println("new thread created: " + t.getState());
    }

    public void runnableStateTest() {
        Thread t = new Thread("runnableStateTesting");
        t.start();
        System.out.println("state after Thread.start():" + t.getState());
    }

    public void blockedStateTest() {

        System.out.println("------------blocked state test begin------------");

        final Object lock = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    while(true) {

                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    int loopTimes = Integer.MAX_VALUE;
                    for(int i = 0; i < loopTimes; i ++) {

                    }
                }
            }
        };
        t2.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                synchronized (lock) {
                    int loopTimes = Integer.MAX_VALUE;
                    for(int i = 0; i < loopTimes; i ++) {

                    }
                }
            }
        };
        t3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("t2.state=" + t2.getState());
        System.out.println("t3.state=" + t3.getState());

        System.out.println("------------blocked state test end------------");

    }

    public void waitingStateTest() {
        System.out.println("------------waiting state test begin------------");
        final Object lock = new Object();

        final Thread t = new Thread("waitingStateTesting") {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        int loopTimes = 1000000;
        for(int i = 0; i < loopTimes; i ++) {

        }
        System.out.println("thread state after wait():" + t.getState());

        System.out.println("------------waiting state test end------------");
    }

    public void timedWaitingStateTest() {
        System.out.println("------------timedWaiting state test begin------------");

        final Thread t = new Thread("threadStateTesting") {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        int loopTimes = 1000000;
        for(int i = 0; i < loopTimes; i ++) {

        }
        System.out.println("thread state after Thread.sleep():" + t.getState());

        System.out.println("------------timedWaiting state test end------------");
    }

    public void terminatedStateTest() {
        System.out.println("------------terminated state test begin------------");
        Thread t = new Thread("terminatedStateTesting") {
            @Override
            public void run() {
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread state after the end of Thread.run(): " + t.getState());
        System.out.println("------------terminated state test end------------");
    }

}