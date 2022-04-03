/**
 * Copyright (C), 2015-2021, 京东
 * FileName: CompletionServiceFutureOrder
 * Author:   codefans
 * Date:     2021/8/4 14:17
 * Description:
 */
package com.codefans.basicjava.concurrent.completionservice;


import com.codefans.basicjava.concurrent.threadpool.NamedThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 *
 *
 * @author: codefans
 * @Date: 2021/08/04 14:17
 * @since: 1.0.0
 */
public class CompletionServiceFutureOrder {

    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    private static final ExecutorService executorService = new ThreadPoolExecutor(CORE_SIZE, CORE_SIZE * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(100000), new NamedThreadFactory("CompletionServiceThreadPool"), new ThreadPoolExecutor.CallerRunsPolicy());

    private static final CompletionService completionService = new ExecutorCompletionService(executorService);

    public void submitOrderResult(List<Callable<String>> taskList) {
        List<Future<String>> resultList = new ArrayList<>(taskList.size());
        Future<String> future = null;
        for(Callable<String> task : taskList) {
            future = completionService.submit(task);
            resultList.add(future);
        }

        for(Future<String> result : resultList) {
            try {
                String str = result.get();
                System.out.println(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

    public void submitNoOrderResult(List<Callable<String>> taskList) {
        int taskCount = taskList.size();
        for(Callable<String> task : taskList) {
            completionService.submit(task);
        }

        for(int i = 0; i < taskCount; i ++) {
            try {
                Future<String> future = completionService.poll(10, TimeUnit.SECONDS);
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}