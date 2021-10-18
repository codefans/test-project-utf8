package com.codefans.interview.concurrent.throughput;


import com.codefans.basicjava.concurrent.threadpool.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * ExecutorService吞吐量
 *
 * @author: codefans
 * @Date: 2021/10/18 10:03
 * @since: 1.0.0
 */
public class ExecutorServiceThrougnput {

    public static void main(String[] args) {

        int coreSize = Runtime.getRuntime().availableProcessors();
        int maxSize = coreSize * 2 + 1;
        long timeout = 1000;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue queue = new LinkedBlockingQueue(100000);
        ThreadFactory threadFactory = new NamedThreadFactory("ExecutorServiceThroughputTest");
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(coreSize, maxSize, timeout, timeUnit, queue, threadFactory, rejectedExecutionHandler);


        /**
         * 60秒
         */
        long duration = 10000;
        long begin = System.currentTimeMillis();

//        while(System.currentTimeMillis() - begin < duration) {
//            System.out.println(System.currentTimeMillis() - begin);
//        }

        long submitTask = 0;
        loop:
        while(System.currentTimeMillis() - begin < duration) {

            List<Future<String>> resultList = new ArrayList<>(1000000);
            do {
                Future<String> result = threadPool.submit(() -> {
                    long sleepTime = new Random().nextInt(10);
                    sleepTime = sleepTime * 100;
                    Thread.sleep(sleepTime);
                    return "sleepTime[" + sleepTime + "]task.";
                });
                resultList.add(result);
                submitTask++;
                if(System.currentTimeMillis() - begin >= duration) {
                    System.out.println("cost time=[" + (System.currentTimeMillis() - begin) + "ms], break loop from inner while.");
                    break loop;
                }
            } while(submitTask % 100000 != 0);

            for(Future<String> task : resultList) {
                try {
//                    task.get();
                    System.out.println("result=[" + task.get() + "], taskIndex=" + submitTask);

                    if(System.currentTimeMillis() - begin >= duration) {
                        System.out.println("cost time=[" + (System.currentTimeMillis() - begin) + "ms], break loop from inner for.");
                        break loop;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            resultList.clear();


        }

        long timeCost = System.currentTimeMillis() - begin;
        System.out.println("ExecutorService, submitTask=" + submitTask + ", completedTaskCount=" + threadPool.getCompletedTaskCount() + ", total time cost:[" + timeCost + "ms], throughput=[" + (submitTask / (timeCost/1000)) + "]qps");
        System.out.println("ExecutorService, activeCount=" + threadPool.getActiveCount() + ", completedTaskCount=" + threadPool.getCompletedTaskCount() + ", taskCount=" + threadPool.getTaskCount() + ", threadPool=" + threadPool);
//        threadPool.shutdown();
        threadPool.shutdownNow();

    }

}