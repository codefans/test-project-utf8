package com.codefans.reusablecode.netty;

import org.junit.Before;
import org.junit.Test;

public class MultiProducerSingleConsumerTest {

    MultiProducerSingleConsumer mpsc;
    int count = 1000000;
    int threadCount = 4;

    @Before
    public void before() {
        mpsc = new MultiProducerSingleConsumer();
    }

    @Test
    public void mpscQueueTest() {
        System.out.println(count/threadCount);
        Thread producerTask1 = new Thread(new ProducerTask(count/threadCount));
        Thread producerTask2 = new Thread(new ProducerTask(count/threadCount));
        Thread producerTask3 = new Thread(new ProducerTask(count/threadCount));
        Thread producerTask4 = new Thread(new ProducerTask(count/threadCount));
        Thread consumerTask = new Thread(new ConsumerTask(count, 1));

        long start = System.currentTimeMillis();
        producerTask1.start();
        producerTask2.start();
        producerTask3.start();
        producerTask4.start();

        try {
            producerTask1.join();
            producerTask2.join();
            producerTask3.join();
            producerTask4.join();
            System.out.println("mpscQueueTest() producer cost=" + (System.currentTimeMillis() - start) + ", size=" + mpsc.size());//240ms

            start = System.currentTimeMillis();
            consumerTask.start();
            consumerTask.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("mpscQueueTest() consumer cost=" + (System.currentTimeMillis() - start) + ", size=" + mpsc.size()); //31ms
    }

    class ProducerTask implements Runnable {
        int count;
        ProducerTask(int count) {
            this.count = count;
        }
        @Override
        public void run() {
            for(int i = 0; i < count; i ++) {
                mpsc.offer(i);
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
                mpsc.poll();
//                System.out.println(spmc.poll());
            }
        }
    }

}
