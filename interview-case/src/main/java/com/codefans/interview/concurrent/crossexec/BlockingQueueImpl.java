package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: codefans
 * @date: 2019-10-08 17:54
 */
public class BlockingQueueImpl {

    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);


    public static void main(String[] args) {

        char[] aI = "1234567890".toCharArray();
        char[] aC = "ABCDEFGHIJ".toCharArray();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for(char c : aI) {

                        q1.take();

                        System.out.print(c);
                        q2.put("OK");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for(char c : aC) {

                        q1.put("OK");
                        System.out.print(c);
                        q2.take();

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }

            }
        }, "t2");

        t1.start();
        t2.start();

    }

}
