/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ExecutorServiceFutureOrder
 * Author:   caishengzhi
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
public class ExecutorServiceFutureOrder {

    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    private static final ExecutorService executorService = new ThreadPoolExecutor(CORE_SIZE, CORE_SIZE * 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(100000), new NamedThreadFactory("CompletionServiceThreadPool"), new ThreadPoolExecutor.CallerRunsPolicy());

    public void submitOrderResult(List<Callable<String>> taskList) {
        List<Future> resultList = new ArrayList<>(taskList.size());
        Future<String> future = null;
        for(Callable<String> task : taskList) {
            future = executorService.submit(task);
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

}