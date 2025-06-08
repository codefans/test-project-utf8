package com.codefans.reusablecode.netty;

import org.jctools.queues.SpscArrayQueue;

public class SingleProducerSingleConsumer {

    SpscArrayQueue<Integer> queue = new SpscArrayQueue<>(1000000);

    public void offer(Integer val) {
        queue.offer(val);
    }

    public Integer poll() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }

}
