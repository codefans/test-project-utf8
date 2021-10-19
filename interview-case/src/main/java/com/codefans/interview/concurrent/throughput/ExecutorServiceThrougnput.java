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
public class ExecutorServiceThrougnput extends ThreadPoolBase {

    public static void main(String[] args) {

        ExecutorServiceThrougnput executorServiceThrougnput = new ExecutorServiceThrougnput();
        executorServiceThrougnput.execute();


    }

    public void execute() {

        long begin = System.currentTimeMillis();
        long submitTask = 0;
        loop:
        while(System.currentTimeMillis() - begin < duration) {

            List<Future<String>> resultList = new ArrayList<>(1000000);
            int taskIndex = 0;
            do {
                taskIndex = taskIndex >= 5 ? taskIndex % 5 : taskIndex;
                Future<String> result = threadPool.submit(baseTaskList.get(taskIndex));
                resultList.add(result);
                submitTask++;
                taskIndex++;
                if(System.currentTimeMillis() - begin >= duration) {
                    System.out.println("cost time=[" + (System.currentTimeMillis() - begin) + "ms], break loop from inner while.");
                    break loop;
                }
            } while(submitTask % taskCount != 0);

            for(Future<String> task : resultList) {
                try {
                    task.get();
//                    System.out.println("result=[" + task.get() + "], taskIndex=" + submitTask);

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
        System.out.println("ExecutorService, submitTask=" + submitTask + ", completedTaskCount=" + threadPool.getCompletedTaskCount() + ", total time cost:[" + timeCost + "ms], throughput=[" + (threadPool.getCompletedTaskCount() / (timeCost/1000)) + "]qps");
//        System.out.println("ExecutorService, activeCount=" + threadPool.getActiveCount() + ", completedTaskCount=" + threadPool.getCompletedTaskCount() + ", taskCount=" + threadPool.getTaskCount() + ", threadPool=" + threadPool);
//        threadPool.shutdown();
        threadPool.shutdownNow();

    }

}