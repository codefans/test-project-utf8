package com.codefans.basicjava.concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: codefans
 * @date: 2019-07-04 13:18
 */
public class DefaultThreadPool {

    private int coreSize;

    private int maximumPoolSize;

    private int queueSize;

    private long keepAliveTime;

    private TimeUnit timeUnit;

    private BlockingQueue<Runnable> blockingQueue;

    private ThreadFactory threadFactory;

    private RejectedExecutionHandler rejectedHandler;

    private ThreadPoolExecutor threadPoolExecutor;

    public DefaultThreadPool() {

        coreSize = Runtime.getRuntime().availableProcessors();
        maximumPoolSize = coreSize << 1;
        queueSize = 10 * 10000;

        keepAliveTime = 10 * 1000;
        timeUnit = TimeUnit.MILLISECONDS;
        blockingQueue = new LinkedBlockingQueue<>(queueSize);

        threadFactory = new NamedThreadFactory("DefaultThreadPool_");
        rejectedHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                Thread t = new Thread(r);
                System.out.println("thread:[" + t.getName() + "] rejected!");
            }
        };
        threadPoolExecutor = new ThreadPoolExecutor(coreSize, maximumPoolSize, keepAliveTime, timeUnit, blockingQueue, rejectedHandler);

    }

    public void execute(Runnable r) {
        threadPoolExecutor.execute(r);
    }

    public Future<?> submit(Runnable r) {
        return threadPoolExecutor.submit(r);
    }

    public void submit(int submitTimes, Runnable task) {
        List<Future<?>> futureList = new ArrayList<Future<?>>(submitTimes);
        for(int i = 0; i < submitTimes; i ++) {
            Future<?> result = threadPoolExecutor.submit(task);
            futureList.add(result);
        }

        for(int i = 0; i < submitTimes; i ++) {
            Future<?> future = futureList.get(i);
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        threadPoolExecutor.shutdown();
    }

    public void shutdownNow() {
        threadPoolExecutor.shutdownNow();
    }


}
