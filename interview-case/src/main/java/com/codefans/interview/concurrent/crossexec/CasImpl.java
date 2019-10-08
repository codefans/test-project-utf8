package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: codefans
 * @date: 2019-10-08 17:39
 */
public class CasImpl {

    enum ReadyToRun {T1, T2}

    static volatile ReadyToRun r = ReadyToRun.T1; //思考为什么必须volatile

    public static void main(String[] args) {

        char[] aI = "1234567890".toCharArray();
        char[] aC = "ABCDEFGHIJ".toCharArray();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for(char c : aI) {

                        while(r != ReadyToRun.T1) {}
                        System.out.print(c);
                        r = ReadyToRun.T2;

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

                        while(r != ReadyToRun.T2) {}
                        System.out.print(c);
                        r = ReadyToRun.T1;

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
