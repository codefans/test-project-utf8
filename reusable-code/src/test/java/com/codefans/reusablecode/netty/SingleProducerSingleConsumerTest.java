package com.codefans.reusablecode.netty;

import org.junit.Before;
import org.junit.Test;

public class SingleProducerSingleConsumerTest {

    SingleProducerSingleConsumer spsc;
    int count = 1000000;
    int threadCount = 1;

    @Before
    public void before() {
        spsc = new SingleProducerSingleConsumer();
    }

    @Test
    public void spscQueueTest() {
        System.out.println(count/threadCount);
        Thread producerTask = new Thread(new ProducerTask(count));
        Thread consumerTask1 = new Thread(new ConsumerTask(count, threadCount));

        long start = System.currentTimeMillis();
        producerTask.start();


        try {
            producerTask.join();
            System.out.println("spscQueueTest() producer cost=" + (System.currentTimeMillis() - start) + ", size=" + spsc.size());//61ms

            start = System.currentTimeMillis();
            consumerTask1.start();

            consumerTask1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("spscQueueTest() consumer cost=" + (System.currentTimeMillis() - start) + ", size=" + spsc.size()); //28
    }

    class ProducerTask implements Runnable {
        int count;
        ProducerTask(int count) {
            this.count = count;
        }
        @Override
        public void run() {
            for(int i = 0; i < count; i ++) {
                spsc.offer(i);
            }
        }
    }

    class ConsumerTask implements Runnable {
        int count;
        int threadCount;

        ConsumerTask(int count, int threadCount) {
            this.count = count;
            this.threadCount = threadCount;
        }
        @Override
        public void run() {
            for(int i = 0; i < count/threadCount; i ++) {
                spsc.poll();
//                System.out.println(spmc.poll());
            }
        }
    }

}
