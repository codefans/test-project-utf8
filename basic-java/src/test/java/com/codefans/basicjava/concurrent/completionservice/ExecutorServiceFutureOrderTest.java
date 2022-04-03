/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ExecutorServiceFutureOrderTest
 * Author:   codefans
 * Date:     2021/8/4 14:45
 * Description:
 */
package com.codefans.basicjava.concurrent.completionservice;


import com.codefans.basicjava.util.CommonsDateUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 *
 *
 * @author: codefans
 * @Date: 2021/08/04 14:45
 * @since: 1.0.0
 */
public class ExecutorServiceFutureOrderTest {

    @Test
    public void submitOrderResultTest() {
        ExecutorServiceFutureOrder executorServiceFutureOrder = new ExecutorServiceFutureOrder();

        int taskCount = 1000;
        List<Callable<String>> taskList = new ArrayList<>(taskCount);
        for(int i = 0; i < taskCount; i ++) {
            final int index = i;
            Callable<String> task = (Callable) () -> "task_" + index + ", completedTime_" + CommonsDateUtils.formatMilliecond(new Date());
            taskList.add(task);
        }
        executorServiceFutureOrder.submitOrderResult(taskList);

    }

}