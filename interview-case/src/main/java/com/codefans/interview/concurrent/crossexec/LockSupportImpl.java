package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: codefans
 * @date: 2019-10-08 17:46
 */
public class LockSupportImpl {

    static Thread t1;
    static Thread t2;

    public static void main(String[] args) {

        char[] aI = "1234567890".toCharArray();
        char[] aC = "ABCDEFGHIJ".toCharArray();



        t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for(char c : aI) {

                        LockSupport.park();
                        System.out.print(c);
                        LockSupport.unpark(t2);


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }, "t1");

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for(char c : aC) {

                        System.out.print(c);
                        LockSupport.unpark(t1);
                        LockSupport.park();

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
