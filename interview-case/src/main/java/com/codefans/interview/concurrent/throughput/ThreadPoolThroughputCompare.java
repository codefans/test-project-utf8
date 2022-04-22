package com.codefans.interview.concurrent.throughput;

import com.codefans.basicjava.concurrent.threadpool.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: codefans
 * @Date: 2022-04-13 22:21
 */

public class ThreadPoolThroughputCompare {

    public static void main(String[] args) {

        ThreadPoolThroughputCompare tptc = new ThreadPoolThroughputCompare();
        tptc.compare();

    }

    public void compare() {

        int coreSize = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = coreSize << 1;
        long aliveTime = 3000;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ArrayBlockingQueue regularQueue = new ArrayBlockingQueue(100000);
        NamedThreadFactory regularThreadFactory = new NamedThreadFactory("regular-thread-pool");
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor regularThreadPool = new ThreadPoolExecutor(coreSize, maxPoolSize, aliveTime, timeUnit, regularQueue, regularThreadFactory, abortPolicy);

        ArrayBlockingQueue completionQueue = new ArrayBlockingQueue(100000);
        NamedThreadFactory completionThreadFactory = new NamedThreadFactory("completion-thread-pool");
        ThreadPoolExecutor completionThreadPool = new ThreadPoolExecutor(coreSize, maxPoolSize, aliveTime, timeUnit, completionQueue, completionThreadFactory, abortPolicy);
        CompletionService completionService = new ExecutorCompletionService(completionThreadPool);

        int taskCount = 100000;
        int[] sleepTimeArr = new int[taskCount];
        Random random = new Random();
        for(int i = 0; i < sleepTimeArr.length; i ++) {
            sleepTimeArr[i] = random.nextInt(10);
        }

        long beginTime = System.currentTimeMillis();
        List<Future> futureList = new ArrayList<>(taskCount);
        for(int i = 0; i < taskCount; i ++) {
            futureList.add(regularThreadPool.submit(new RunnableTask(sleepTimeArr[i])));
        }
        for(int i = 0; i < taskCount; i ++) {
            try {
                futureList.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("regular time cost:[" + (System.currentTimeMillis() - beginTime) + "]ms");

        beginTime = System.currentTimeMillis();
        for(int i = 0; i < taskCount; i ++) {
            completionService.submit(new RunnableTask(sleepTimeArr[i]));
        }
        Future future = null;
        for(int i = 0; i < taskCount; i ++) {
//            completionService.poll();
            try {
                future = completionService.take();
//                future = completionService.poll();
                if(future != null) {
                    future.get();
                } else {
                    System.out.println("第[" + (i + 1) + "]个任务future为null。");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("completion time cost:[" + (System.currentTimeMillis() - beginTime) + "]ms");

//        shutdown(regularThreadPool);
//        shutdown(completionThreadPool);
        regularThreadPool.shutdown();
        completionThreadPool.shutdown();

    }

    class RunnableTask implements Callable {

        private int randomSleepTime;

        RunnableTask(int randomSleepTime) {
            this.randomSleepTime = randomSleepTime;
        }

        @Override
        public Object call() throws Exception {
            try {
                Thread.sleep(randomSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private void shutdown(ThreadPoolExecutor threadPool) {
        threadPool.shutdown();
    }

}
