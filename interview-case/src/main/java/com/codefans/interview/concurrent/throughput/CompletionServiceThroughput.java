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
public class CompletionServiceThroughput extends ThreadPoolBase {

    public static void main(String[] args) {

        CompletionServiceThroughput completionServiceThroughput = new CompletionServiceThroughput();
        completionServiceThroughput.execute();


    }

    public void execute() {

        CompletionService completionService = new ExecutorCompletionService(threadPool);

        long begin = System.currentTimeMillis();
        long submitTask = 0;
        loop:
        while(System.currentTimeMillis() - begin < duration) {

            int taskIndex = 0;
            do {
                taskIndex = taskIndex >= 5 ? taskIndex % 5 : taskIndex;
                completionService.submit(baseTaskList.get(taskIndex));
                submitTask++;
                taskIndex++;
                if(System.currentTimeMillis() - begin >= duration) {
                    System.out.println("cost time=[" + (System.currentTimeMillis() - begin) + "ms], break loop from inner while.");
                    break loop;
                }
            } while(submitTask % taskCount != 0);

            for(int i = 0; i < taskCount; i ++) {
                completionService.poll();
                if(System.currentTimeMillis() - begin >= duration) {
                    System.out.println("cost time=[" + (System.currentTimeMillis() - begin) + "ms], break loop from inner for.");
                    break loop;
                }
            }

        }

        long timeCost = System.currentTimeMillis() - begin;
        System.out.println("CompletionService, submitTask=" + submitTask + ", completedTaskCount=" + threadPool.getCompletedTaskCount() + ", total time cost:[" + timeCost + "ms], throughput=[" + (threadPool.getCompletedTaskCount() / (timeCost/1000)) + "]qps");
//        System.out.println("CompletionService, activeCount=" + threadPool.getActiveCount() + ", completedTaskCount=" + threadPool.getCompletedTaskCount() + ", taskCount=" + threadPool.getTaskCount() + ", threadPool=" + threadPool);
//        threadPool.shutdown();
        threadPool.shutdownNow();

    }
}