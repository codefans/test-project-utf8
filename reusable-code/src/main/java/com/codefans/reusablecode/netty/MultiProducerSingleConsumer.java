package com.codefans.reusablecode.netty;

import org.jctools.queues.MpscArrayQueue;

public class MultiProducerSingleConsumer {

    MpscArrayQueue<Integer> queue = new MpscArrayQueue<>(1000000);

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
