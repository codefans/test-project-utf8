/**
 * Copyright (C), 2015-2020, 京东
 * FileName: PassParamBeyondThread
 * Author:   codefans
 * Date:     2020/4/2 11:52
 * Description: 线程间传参
 */
package com.codefans.basicjava.concurrent.threadlocal;


import java.util.concurrent.CountDownLatch;

/**
 *
 * 线程间传参
 *
 * @author: codefans
 * @Date: 2020/04/02 11:52
 * @since: 1.0.0
 */
public class PassParamBeyondThread {

    private static ThreadLocal<Integer> dataThreadLocal = new ThreadLocal<Integer>();


    public static void main(String[] args) throws InterruptedException {

        dataThreadLocal.set(1);

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("data=" + dataThreadLocal.get());

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("data2=" + dataThreadLocal.get());
                        countDownLatch.countDown();
                    }
                }).start();

            }
        }).start();

        countDownLatch.await();

        System.out.println("data3=" + dataThreadLocal.get());

    }


}