/**
 * Copyright (C), 2015-2021, 京东
 * FileName: CompletionServiceFutureOrderTest
 * Author:   codefans
 * Date:     2021/8/4 14:46
 * Description:
 */
package com.codefans.basicjava.concurrent.completionservice;


import com.codefans.basicjava.util.CommonsDateUtils;
import com.codefans.basicjava.util.StopWatchUtils;
import org.apache.commons.lang.time.StopWatch;
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
 * @Date: 2021/08/04 14:46
 * @since: 1.0.0
 */
public class CompletionServiceFutureOrderTest {

    @Test
    public void submitOrderResultTest() {
        CompletionServiceFutureOrder completionServiceFutureOrder = new CompletionServiceFutureOrder();

        StopWatchUtils.start();
        int taskCount = 100000;
        List<Callable<String>> taskList = new ArrayList<>(taskCount);
        for(int i = 0; i < taskCount; i ++) {
            final int index = i;
            Callable<String> task = (Callable) () -> "task_" + index + ", completedTime_" + CommonsDateUtils.formatMilliecond(new Date());
            taskList.add(task);
        }
//        completionServiceFutureOrder.submitOrderResult(taskList);
        completionServiceFutureOrder.submitNoOrderResult(taskList);
        StopWatchUtils.stop();
        System.out.println("耗时:[" + StopWatchUtils.getTimeInMills() + "]ms");
    }

}