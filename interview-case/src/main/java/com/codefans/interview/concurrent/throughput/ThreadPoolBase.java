package com.codefans.interview.concurrent.throughput;


import com.codefans.basicjava.concurrent.threadpool.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 线程池基础类
 *
 * @author: codefans
 * @Date: 2021/10/19 09:56
 * @since: 1.0.0
 */
public class ThreadPoolBase {

    int coreSize = Runtime.getRuntime().availableProcessors();
    int maxSize = coreSize * 2 + 1;
    long timeout = 1000;
    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
    LinkedBlockingQueue queue = new LinkedBlockingQueue(100000);
    ThreadFactory threadFactory = new NamedThreadFactory("ExecutorServiceThroughputTest");
    RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(coreSize, maxSize, timeout, timeUnit, queue, threadFactory, rejectedExecutionHandler);

    List<Callable<String>> baseTaskList = new ArrayList<>(8);

    /**
     * 任务总数10万
     */
    int taskCount = 10 * 10000;
    /**
     * 10秒
     */
    long duration = 10000;

    public ThreadPoolBase() {
        Callable<String> task01 = () -> {
            long sleepTime = 10;
            Thread.sleep(sleepTime);
            return "task01, sleep[" + sleepTime + "]ms.";
        };
        Callable<String> task02 = () -> {
            long sleepTime = 20;
            Thread.sleep(sleepTime);
            return "task01, sleep[" + sleepTime + "]ms.";
        };
        Callable<String> task03 = () -> {
            long sleepTime = 30;
            Thread.sleep(sleepTime);
            return "task01, sleep[" + sleepTime + "]ms.";
        };
        Callable<String> task04 = () -> {
            long sleepTime = 40;
            Thread.sleep(sleepTime);
            return "task01, sleep[" + sleepTime + "]ms.";
        };
        Callable<String> task05= () -> {
            long sleepTime = 50;
            Thread.sleep(sleepTime);
            return "task01, sleep[" + sleepTime + "]ms.";
        };
        baseTaskList.add(task01);
        baseTaskList.add(task02);
        baseTaskList.add(task03);
        baseTaskList.add(task04);
        baseTaskList.add(task05);
    }

}