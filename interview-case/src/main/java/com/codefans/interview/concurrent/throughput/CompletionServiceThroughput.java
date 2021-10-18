package com.codefans.interview.concurrent.throughput;


import com.codefans.basicjava.concurrent.threadpool.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * CompletionService吞吐量
 *
 * @author: codefans
 * @Date: 2021/10/18 10:03
 * @since: 1.0.0
 */
public class CompletionServiceThroughput {

    public static void main(String[] args) {

        int coreSize = Runtime.getRuntime().availableProcessors();
        int maxSize = coreSize * 2 + 1;
        long timeout = 1000;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue queue = new LinkedBlockingQueue(100000);
        ThreadFactory threadFactory = new NamedThreadFactory("ExecutorServiceThroughputTest");
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(coreSize, maxSize, timeout, timeUnit, queue, threadFactory, rejectedExecutionHandler);
        CompletionService completionService = new ExecutorCompletionService(threadPool);

        /**
         * 60秒
         */
        long duration = 10000;
        long begin = System.currentTimeMillis();
        long submitTask = 0;
        loop:
        while(System.currentTimeMillis() - begin < duration) {

            do {
                completionService.submit(() -> {
                    for(int i = 0; i < 100000; i ++) {

                    }
                    return "success";
                });
                submitTask++;
                if(System.currentTimeMillis() - begin >= duration) {
                    System.out.println("cost time=[" + (System.currentTimeMillis() - begin) + "ms], break loop from inner while.");
                    break loop;
                }
            } while(submitTask % 100000 != 0);

            for(int i = 0; i < 100000; i ++) {
                completionService.poll();
                if(System.currentTimeMillis() - begin >= duration) {
                    System.out.println("cost time=[" + (System.currentTimeMillis() - begin) + "ms], break loop from inner for.");
                    break loop;
                }
            }

        }

        long timeCost = System.currentTimeMillis() - begin;
        System.out.println("CompletionService, submitTask=" + submitTask + ", completedTaskCount=" + threadPool.getCompletedTaskCount() + ", total time cost:[" + timeCost + "ms], throughput=[" + (submitTask / (timeCost/1000)) + "]qps");
        System.out.println("CompletionService, activeCount=" + threadPool.getActiveCount() + ", completedTaskCount=" + threadPool.getCompletedTaskCount() + ", taskCount=" + threadPool.getTaskCount() + ", threadPool=" + threadPool);
//        threadPool.shutdown();
        threadPool.shutdownNow();

    }
}