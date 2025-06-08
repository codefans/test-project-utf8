package com.codefans.reusablecode.netty;

import org.junit.Before;
import org.junit.Test;

public class MultiProducerMultiConsumerTest {

    MultiProducerMultiConsumer mpmc;
    int count = 1000000;
    int threadCount = 4;

    @Before
    public void before() {
        mpmc = new MultiProducerMultiConsumer();
    }

    @Test
    public void mpmcQueueTest() {
        System.out.println(count/threadCount);
        Thread producerTask1 = new Thread(new ProducerTask(count/threadCount));
        Thread producerTask2 = new Thread(new ProducerTask(count/threadCount));
        Thread producerTask3 = new Thread(new ProducerTask(count/threadCount));
        Thread producerTask4 = new Thread(new ProducerTask(count/threadCount));

        Thread consumerTask1 = new Thread(new ConsumerTask(count, threadCount));
        Thread consumerTask2 = new Thread(new ConsumerTask(count, threadCount));
        Thread consumerTask3 = new Thread(new ConsumerTask(count, threadCount));
        Thread consumerTask4 = new Thread(new ConsumerTask(count, threadCount));

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
            System.out.println("mpmcQueueTest() producer cost=" + (System.currentTimeMillis() - start) + ", size=" + mpmc.size());//229ms

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
        System.out.println("mpmcQueueTest() consumer cost=" + (System.currentTimeMillis() - start) + ", size=" + mpmc.size()); //216ms
    }

    class ProducerTask implements Runnable {
        int count;
        ProducerTask(int count) {
            this.count = count;
        }
        @Override
        public void run() {
            for(int i = 0; i < count; i ++) {
                mpmc.offer(i);
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
                mpmc.poll();
//                System.out.println(spmc.poll());
            }
        }
    }

}
