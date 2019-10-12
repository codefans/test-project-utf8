package com.codefans.interview.concurrent.onebyone;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: codefans
 * @date: 2019-10-11 16:08
 */
public class ArrayBlockingQueueImpl implements RunOneByOneApi {

    private BlockingQueue<String> q2 = new ArrayBlockingQueue(1);
    private BlockingQueue<String> q3 = new ArrayBlockingQueue(1);

    private final String OK = "ok";

    @Override
    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        q2.put(OK);
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {

        String action = q2.take();
        if(OK.equals(action)) {
            printSecond.run();
            q3.put(OK);
        }



    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {

        String action = q3.take();
        if(OK.equals(action)) {
            printThird.run();
        }



    }
}
