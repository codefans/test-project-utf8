package com.codefans.basicjava.concurrent.threadlocal;

import com.codefans.basicjava.concurrent.threadpool.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: ShengzhiCai
 * @Date: 2023-07-25 21:18
 */

public class ThreadLocalConcurrencyProblemInThreadPool {

    public static void main(String[] args) {

        ThreadLocalConcurrencyProblemInThreadPool test = new ThreadLocalConcurrencyProblemInThreadPool();
        test.exec();

    }

    public void exec() {
        int coreSize = 3;
        int maxSize = 3;
        long timeout = 5;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue queue = new LinkedBlockingQueue(10000);
        ThreadFactory threadFactory = new NamedThreadFactory("threadLocal_test");
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ExecutorService executorService = new ThreadPoolExecutor(coreSize, maxSize, timeout, timeUnit, queue, threadFactory, rejectedExecutionHandler);
        Future future = executorService.submit(new ThreadTask("224", "task1"));
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int taskCount = 4;
        List<Future> futureList = new ArrayList<>();
        for(int i = 0; i < taskCount; i ++) {
            future = executorService.submit(new ThreadTask("225", "task2"));
            futureList.add(future);
        }

        for(int i = 0; i < taskCount; i ++) {
            future = futureList.get(i);
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

    }

    class ThreadTask implements Runnable {

        private String platform;

        private String taskName;

        ThreadTask(String platform, String taskName) {
            this.platform = platform;
            this.taskName = taskName;
        }

        @Override
        public void run() {

            try {
                /**
                 * 如果每个线程都是先set值、get值、clear清理缓存, 也不会有问题;
                 * 只有其中一个步骤是有条件才执行的, 就可能造成数据不一致
                 */
                if("task1".equals(taskName)) {
                    PlatformHolder.set(platform);
                }


                platform = PlatformHolder.get();
                System.out.println("platform=" + platform + ", taskName=" + taskName + ", threadName=" + Thread.currentThread().getName());

                if("224".equalsIgnoreCase(platform) && "task2".equalsIgnoreCase(taskName)) {
                    throw new RuntimeException("platform和taskName不匹配");
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            } finally {
                if(!"task1".equals(taskName)) {
                    PlatformHolder.clear();
                }
            }


        }
    }



}

class PlatformHolder {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void set(String platform) {
        threadLocal.set(platform);
    }

    public static String get() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
