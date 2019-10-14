package com.codefans.interview.algorithm.leetcode.concurrency;

import com.codefans.interview.concurrent.onebyone.RunOneByOneApi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: codefans
 * @Date: 2019-10-14 21:06
 */

public class No1114PrintInOrder_ArrayBlockingQueue implements RunOneByOneApi {

    private final String OK = "ok";

    private BlockingQueue<String> q1 = new ArrayBlockingQueue<String>(1);
    private BlockingQueue<String> q2 = new ArrayBlockingQueue<String>(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        q1.put(OK);


    }

    public void second(Runnable printSecond) throws InterruptedException {

        String data = q1.take();
        if(OK.equals(data)) {
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            q2.put(OK);
        }


    }

    public void third(Runnable printThird) throws InterruptedException {

        String data = q2.take();
        if(OK.equals(data)) {
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }

    }

}
