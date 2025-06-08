package com.codefans.reusablecode.netty;

import org.jctools.queues.SpmcArrayQueue;

public class SingleProducerMultiConsumer {

    SpmcArrayQueue<Integer> queue = new SpmcArrayQueue<>(1000000);

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
