package com.codefans.interview.concurrent.throughput;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @Author: codefans
 * @Date: 2022-04-22 9:07
 */

public class CompletableFutureThroughput extends ThreadPoolBase {

    public static void main(String[] args) {

        CompletableFutureThroughput completableFutureThroughput = new CompletableFutureThroughput();
        completableFutureThroughput.execute();

    }

    private void execute() {

        int taskCount = 100000;
        int[] sleepTimeArr = new int[taskCount];
        Random random = new Random();
        for(int i = 0; i < sleepTimeArr.length; i ++) {
            sleepTimeArr[i] = random.nextInt(10);
        }

        long beginTime = System.currentTimeMillis();
        List<CompletableFuture> futureList = new ArrayList<>(taskCount);
        for(int i = 0; i < taskCount; i ++) {
            CompletableFuture completableFuture = CompletableFuture.runAsync(new RunnableTask(sleepTimeArr[i]), threadPool);
            futureList.add(completableFuture);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        System.out.println("CompletableFuture submit cost:[" + (System.currentTimeMillis() - beginTime) + "]ms");

        for(int i = 0; i < taskCount; i ++) {
            try {
                futureList.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CompletableFuture complete cost:[" + (System.currentTimeMillis() - beginTime) + "]ms");

        threadPool.shutdown();

    }

    class RunnableTask implements Runnable {

        private int randomSleepTime;

        RunnableTask(int randomSleepTime) {
            this.randomSleepTime = randomSleepTime;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(randomSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
