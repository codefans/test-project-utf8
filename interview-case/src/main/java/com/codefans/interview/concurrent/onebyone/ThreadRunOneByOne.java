package com.codefans.interview.concurrent.onebyone;

import com.codefans.basicjava.concurrent.threadpool.DefaultThreadPool;
import com.codefans.basicjava.concurrent.threadpool.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: codefans
 * @date: 2019-09-30 14:07
 */
public class ThreadRunOneByOne {

    private DefaultThreadPool threadPool = null;
    List<Future<?>> futureList = null;
    Future<?> future = null;

    public ThreadRunOneByOne() {

        int queueSize = 10 * 10000;
        ThreadFactory threadFactory = new NamedThreadFactory("ThreadRunOneByOne_");
        RejectedExecutionHandler rejectedHandler = new ThreadPoolExecutor.CallerRunsPolicy();

        threadPool = new DefaultThreadPool(queueSize, threadFactory, rejectedHandler);
        futureList = new ArrayList<Future<?>>();

    }

    public static void main(String[] args) {
        try {
            ThreadRunOneByOne threadRunOneByOne = new ThreadRunOneByOne();
            threadRunOneByOne.runOneByOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runOneByOne() {

//        this.implJoin();
//        this.implByWaitNotify(); //有问题
//        this.implByCountDownLatch();


    }

    public void implJoin() {
        int threadNums = 100000;
        Runnable task = null;
        Runnable lastTask = null;
        Thread thread = null;
        Thread lastThread = null;

        for(int i = 0; i < threadNums; i ++) {
            final int index = i;
            task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread:[" + index + "], is running...");
                }
            };

            if(i == 0) {
                lastThread = new Thread(task);
                lastThread.start();
            } else {

                try {
                    lastThread.join();
                    thread = new Thread(task);
                    thread.start();

                    lastThread = thread;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        this.waitAllTaskComplete();
    }

    /**
     * 这种方案-有点问题
     */
    public void implByWaitNotify() {

        Object lock = null;
        Object lastLock = new Object();

        int threadNums = 1000;

        for(int i = 0; i < threadNums; i ++) {

            lock = new Object();

            future = threadPool.submit(new InnerSyncWaitNotify(lock, lastLock, (i+1)));
            futureList.add(future);

            lastLock = lock;

        }

        this.waitAllTaskComplete();


    }

    /**
     * 通过CountDownLatch实现线程顺序执行
     */
    public void implByCountDownLatch() {

        int threadNums = 10000;

        CountDownLatch firstLatch = new CountDownLatch(1);
        CountDownLatch lastLatch = null;
        CountDownLatch currentLatch = null;
        for(int i = 0; i < threadNums; i ++) {
            if(i == 0) {
                firstLatch.countDown();
                lastLatch = firstLatch;
            } else {
                lastLatch = currentLatch;
            }
            currentLatch = new CountDownLatch(1);
//            new Thread(new InnerThread((i), lastLatch, currentLatch)).start();

            future = threadPool.submit(new InnerThread((i), lastLatch, currentLatch));
            futureList.add(future);

        }

        this.waitAllTaskComplete();

//        CountDownLatch oneLatch = new CountDownLatch(1);
//        oneLatch.countDown();
//        CountDownLatch twoLatch = new CountDownLatch(1);
//        CountDownLatch threeLatch = new CountDownLatch(1);
//        CountDownLatch fourLatch = new CountDownLatch(1);
//        new Thread(new InnerThread(1, oneLatch, twoLatch)).start();
//        new Thread(new InnerThread(2, twoLatch, threeLatch)).start();
//        new Thread(new InnerThread(3, threeLatch, fourLatch)).start();

    }


    public void waitAllTaskComplete() {
        for(int i = 0; i < futureList.size(); i ++) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }

    class InnerThread implements Runnable {

        private int threadIndex;

        private CountDownLatch lastLatch;
        private CountDownLatch currentLatch;
        public InnerThread(int threadIndex, CountDownLatch lastLatch,CountDownLatch currentLatch) {
            this.threadIndex = threadIndex;
            this.lastLatch = lastLatch;
            this.currentLatch = currentLatch;
        }

        @Override
        public void run() {

//            System.out.println(threadIndex + " start, time=" + new Date());

            try {

//                synchronized (ThreadRunOneByOne.class) {

                    lastLatch.await();

                    System.out.println("thread:[" + threadIndex + "], is running...");

                    currentLatch.countDown();

//                }

            } catch (Exception e) {
                e.printStackTrace();
            }
//            System.out.println(threadIndex + " end, time=" + new Date());

        }

    }

    class InnerSyncWaitNotify implements Runnable {

        private Object lock;
        private Object lastLock;
        private int threadIndex;

        InnerSyncWaitNotify(Object lock, Object lastLock, int threadIndex) {
            this.lock = lock;
            this.lastLock = lastLock;
            this.threadIndex = threadIndex;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    lastLock.notify();

                    // .....
                    System.out.println("thread:[" + threadIndex + "] running...");

                    lock.notify();
                    lock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    class InnerSemaphore implements Runnable {

        private Semaphore semaphore;
        private Semaphore lastSemaphore;
        private int index;

        InnerSemaphore(Semaphore semaphore, Semaphore lastSemaphore, int index) {
            this.semaphore = semaphore;
            this.lastSemaphore = lastSemaphore;
            this.index = index;
        }

        @Override
        public void run() {

            try {
                lastSemaphore.release();
                semaphore.acquire();


                System.out.println("thread:[" + index + "], is running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }



    }



}
