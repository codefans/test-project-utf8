package com.codefans.opensource.rocketmq.client;

import com.codefans.basicjava.concurrent.cas.CasLock;
import com.codefans.basicjava.concurrent.threadpool.DefaultThreadPool;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: codefans
 * @date: 2019-07-04 11:33
 */
public class SendMsgLoadbalanceTest {

    private DefaultThreadPool threadPool;

    @Before
    public void before() {
        threadPool = new DefaultThreadPool();
    }

    @Test
    public void sendMsgLoadbalanceTest() {

        SendMsgLoadbalance sendMsgLoadbalance = new SendMsgLoadbalance();
        String queueName = "";

        int executeCount = 10;
        for(int i = 0; i < executeCount; i ++) {
            queueName = sendMsgLoadbalance.selectOneMessageQueue(null);
            System.out.println("queueName=" + queueName);
        }

    }

    @Test
    public void sendMsgLoadbalanceMultiThreadTest() {

        final SendMsgLoadbalance sendMsgLoadbalance = new SendMsgLoadbalance();

        final CasLock lock = new CasLock();
        final AtomicInteger index = new AtomicInteger(1);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                String queueName = sendMsgLoadbalance.selectOneMessageQueue(null);
                System.out.println("taskIndex=" + index.getAndIncrement() + ", queueName=" + queueName);
                lock.unlock();
            }
        };

        int taskCount = 10;
        for(int i = 0; i < taskCount; i ++) {
            threadPool.submit(task);
        }

        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();

    }

}
