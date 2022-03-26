package com.codefans.basicjava.concurrent.threadpool;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: codefans
 * @Date: 2022-03-26 20:22
 */

public class TracingExecutorServiceTest {

    @Test
    public void tracingExecutorServiceTest() {


        ExecutorService executorService = new DefaultThreadPool().getThreadPoolExecutor();
        TracingExecutorService tracingExecutorService = new TracingExecutorService(executorService);

        tracingExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                SharedDomain sharedDomain = SharedDomainThreadLocal.get();
                System.out.println("id=" + sharedDomain.getId() + ", name=" + sharedDomain.getName());
            }
        });

        tracingExecutorService.submit(new Callable<Object>() {
            @Override
            public Object call() {
                SharedDomain sharedDomain = SharedDomainThreadLocal.get();
                System.out.println("id=" + sharedDomain.getId() + ", name=" + sharedDomain.getName());
                return null;
            }
        });

        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tracingExecutorService.shutdown();

    }

}
