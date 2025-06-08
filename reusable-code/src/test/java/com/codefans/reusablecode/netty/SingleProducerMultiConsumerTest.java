package com.codefans.reusablecode.netty;

import org.junit.Before;
import org.junit.Test;

public class SingleProducerMultiConsumerTest {

    SingleProducerMultiConsumer spmc;
    int count = 1000000;
    int threadCount = 4;

    @Before
    public void before() {
        spmc = new SingleProducerMultiConsumer();
    }

    @Test
    public void spmcQueueTest() {
        System.out.println(count/threadCount);
        Thread producerTask = new Thread(new ProducerTask(count));
        Thread consumerTask1 = new Thread(new ConsumerTask(count, threadCount));
        Thread consumerTask2 = new Thread(new ConsumerTask(count, threadCount));
        Thread consumerTask3 = new Thread(new ConsumerTask(count, threadCount));
        Thread consumerTask4 = new Thread(new ConsumerTask(count, threadCount));

        long start = System.currentTimeMillis();
        producerTask.start();


        try {
            producerTask.join();
            System.out.println("spmcQueueTest() producer cost=" + (System.currentTimeMillis() - start) + ", size=" + spmc.size());//68ms

            start = System.currentTimeMillis();
            consumerTask1.start();
            consumerTask2.start();
            consumerTask3.start();
            consumerTask4.start();

            consumerTask1.join();
            consumerTask2.join();
            consumerTask3.join();
            consumerTask4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("spmcQueueTest() consumer cost=" + (System.currentTimeMillis() - start) + ", size=" + spmc.size()); //215
    }

    class ProducerTask implements Runnable {
        int count;
        ProducerTask(int count) {
            this.count = count;
        }
        @Override
        public void run() {
            for(int i = 0; i < count; i ++) {
                spmc.offer(i);
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
                spmc.poll();
//                System.out.println(spmc.poll());
            }
        }
    }

}
