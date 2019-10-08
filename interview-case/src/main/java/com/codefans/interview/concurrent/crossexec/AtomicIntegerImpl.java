package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: codefans
 * @date: 2019-10-08 17:42
 */
public class AtomicIntegerImpl {

    static AtomicInteger turn = new AtomicInteger(2);

    public static void main(String[] args) {

        char[] aI = "1234567890".toCharArray();
        char[] aC = "ABCDEFGHIJ".toCharArray();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for(char c : aI) {

                        while(turn.get() != 1) {}
                        System.out.print(c);
                        turn.set(2);

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

                        while(turn.get() != 2) {}
                        System.out.print(c);
                        turn.set(1);

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
