package com.codefans.basicjava.concurrent.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:
 * @date: 2018-12-17 16:18:57
 * ThreadLocal特性测试
 *
 *
 *
 *
 */
public class ThreadLocalBasic {

    private ThreadLocal<Integer> dataThreadLocal = new ThreadLocal<Integer>();

    private static ThreadLocal<Integer> numThreadLocal = new ThreadLocal<Integer>(){
        public Integer initialValue() {
            return new Integer(1);
        }
    };

    public static void main(String[] args) {
        ThreadLocalBasic threadLocalBasic = new ThreadLocalBasic();
        threadLocalBasic.startup();
    }

    public void startup() {
//        test01();
        test02();
    }

    public void test01() {
        new Thread01().start();
        new Thread02().start();
    }

    public void test02() {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        System.out.println("corePoolSize=" + corePoolSize);

        ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(corePoolSize, new ThreadFactory() {
            private AtomicInteger index = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "threadLocalTestingPool_thread_" + index.getAndIncrement());
            }
        });

        for (int i = 0; i < 50; i++) {
            newCachedThreadPool.execute(new NotSaftThread((i + 1)));
        }
    }

    class Thread01 extends Thread {
        @Override
        public void run() {
            dataThreadLocal.set(1);

            System.out.println("Thread01 running...");

            System.out.println("data in Thread01 is:" + dataThreadLocal.get());

        }
    }

    class Thread02 extends Thread {
        @Override
        public void run() {

            dataThreadLocal.set(2);

            System.out.println("Thread01 running...");

            System.out.println("data in Thread02 is:" + dataThreadLocal.get());

        }
    }

    class NotSaftThread extends Thread {

        private ThreadLocal<Integer> dataThreadLocal = null;

        private int i;
        NotSaftThread(int i) {
            this.i = i;
            dataThreadLocal = new ThreadLocal<Integer>();
            dataThreadLocal.set(i);
        }
        @Override
        public void run() {
//            Integer num = numThreadLocal.get();

            while(true) {
                System.out.println("name:" + Thread.currentThread().getName() + ", num:" + dataThreadLocal.get());
            }

        }
    }



}
