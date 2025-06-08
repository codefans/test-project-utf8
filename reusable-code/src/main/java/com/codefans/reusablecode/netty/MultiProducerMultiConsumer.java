package com.codefans.reusablecode.netty;

import org.jctools.queues.MpmcArrayQueue;

public class MultiProducerMultiConsumer {

    MpmcArrayQueue<Integer> queue = new MpmcArrayQueue<>(1000000);

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
