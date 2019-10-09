package com.codefans.interview.concurrent.onebyone;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: codefans
 * @Date: 2019-10-08 21:48
 */

public class ThreadsOneByOneTest {

    private int[][] testCase;
    private ExecutorService executorService;

    private Runnable firstTask;
    private Runnable secondTask;
    private Runnable thirdTask;

    private VolatileWhileImpl volatileWhileImpl;

    @Before
    public void before() {
        testCase = new int[][]{
            {1,2,3},
            {1,3,2},
            {2,1,3},
            {2,3,1},
            {3,1,2},
            {3,2,1}
        };

        firstTask = new Runnable() {
            @Override
            public void run() {
                System.out.print("first");
            }
        };

        secondTask = new Runnable() {
            @Override
            public void run() {
                System.out.print("second");
            }
        };

        thirdTask = new Runnable() {
            @Override
            public void run() {
                System.out.print("third");
            }
        };

        int threadNum = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(threadNum);

    }

    @Test
    public void volatileWhileImplTest() {

        for(int i = 0; i < testCase.length; i ++) {
            List<Future<?>> futureList = new ArrayList<Future<?>>(3);
            Future<?> future = null;
            volatileWhileImpl = new VolatileWhileImpl();

            for(int j = 0; j < testCase[i].length; j ++) {
                ThreadLocal order = new ThreadLocal();
                order.set(j+1);
                future = executorService.submit(new ExecTask(volatileWhileImpl,order));
                futureList.add(future);
            }
            for(Future res : futureList) {
                try {
                    res.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }

    }

    class ExecTask implements Runnable {
        private int index;
        private VolatileWhileImpl volatileWhileImpl;
        private ThreadLocal<Integer> order;

        ExecTask(VolatileWhileImpl volatileWhileImpl,ThreadLocal order) {
            this.volatileWhileImpl = volatileWhileImpl;
            this.order = order;

        }

        @Override
        public void run() {
            if(order.get() == 1) {
                try {
                    volatileWhileImpl.first(firstTask);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if(order.get() == 2) {
                try {
                    volatileWhileImpl.second(secondTask);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if(order.get() == 3) {
                try {
                    volatileWhileImpl.third(thirdTask);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
