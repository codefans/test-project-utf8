/**
 * Copyright (C), 2015-2020, 京东
 * FileName: CatchExceptionTest
 * Author:   codefans
 * Date:     2020/10/3 14:52
 * Description: 捕获线程的异常测试
 */
package com.codefans.basicjava.concurrent.thread;


import org.junit.Test;

import java.util.concurrent.*;

/**
 *
 * 捕获线程的异常测试
 *
 * @author codefans
 * @date 2020/10/03 14:52
 * @since 1.0.0
 */
public class CatchExceptionTest {

    @Test
    public void catchThreadExceptionTest() {

        try {
            Thread task = new Thread("catchThreadException") {
                @Override
                public void run() {
                    System.out.println("thread body....");
                    throw new RuntimeException("catchThreadException test runtimeException!");
                }
            };
            task.start();
        } catch (Exception e) {
            System.out.println("catch Thread Exception success!" + e.getMessage());
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void catchRunnableExceptionTest() {

        try {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("runnable body....");
                    throw new RuntimeException("catchRunnableException test runtimeException!");
                }

            };

            Thread t = new Thread(task);
            t.start();
        } catch (Exception e) {
            System.out.println("catch runnable Exception success!" + e.getMessage());
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void catchCallableExceptionTest() {

        try {
            Callable task = new Callable() {
                @Override
                public Object call() throws Exception {
                    throw new RuntimeException("callable exception....");
                }
            };

            ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "singleThreadPool");
                }
            });

            Future future = executorService.submit(task);

            /**
             * 执行到这一句时，才会抛出异常
             */
            future.get();

        } catch (Exception e) {
            System.out.println("catch Callable Exception success!" + e.getMessage());
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}