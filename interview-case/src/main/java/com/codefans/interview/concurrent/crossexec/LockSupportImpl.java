package com.codefans.interview.concurrent.crossexec;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: codefans
 * @date: 2019-10-08 17:46
 */
public class LockSupportImpl {

    static Thread t1;
    static Thread t2;

    /**
     * LockSupport.park():
     *     禁用当前线程，出于线程调度的目的，除非有许可证
     *
     * LockSupport.unpark(t2):
     *     如果给定线程的许可证尚不可用，则使它的许可证可用。
     *     如果线程被park阻塞，它将解除阻塞;否则，下一个对park的调用保证不会阻塞。
     *     此操作不能保证完全有效，如果给定的线程尚未启动。
     *
     * @param args
     */
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
