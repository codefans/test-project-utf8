package com.codefans.basicjava.concurrent;

import com.codefans.basicjava.concurrent.cas.CasLock;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: codefans
 * @date: 2019-07-09 15:23
 */
public class ConcurrencyTest {

    int data;

    @Test
    public void basicTest() {

        int threadNum = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        ReentrantLock lock = new ReentrantLock();

        for(int i = 0; i < threadNum; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        System.out.println("data=" + data++);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                    countDownLatch.countDown();
                }

            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
