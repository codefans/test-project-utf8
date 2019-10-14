package com.codefans.interview.concurrent.onebyone;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: codefans
 * @Date: 2019-10-08 21:48
 *
 * 已实现的方案：
 *    1、volatile+while
 *    2、AtomicInteger+while
 *    3、ArrayBlockingQueue
 *    4、CountDownLatch
 *    5、Volatile+Lock+Condition
 *    6、Volatile+Sync+Wait+Notify
 *    7、Volatile+LockSupport
 *
 */

public class ThreadsOneByOneTest {

    private int[][] testCase;
    private ExecutorService executorService;

    private Runnable firstTask;
    private Runnable secondTask;
    private Runnable thirdTask;

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

    public void coreImpl(Class cls) {

        RunOneByOneApi implObj = null;

        for(int i = 0; i < testCase.length; i ++) {
            List<Future<?>> futureList = new ArrayList<Future<?>>(3);
            Future<?> future = null;

            try {
                implObj = (RunOneByOneApi)cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            for(int j = 0; j < testCase[i].length; j ++) {
                final int index = testCase[i][j];
                ThreadLocal<Integer> order = new ThreadLocal<Integer>(){
                    public Integer initialValue() {
                        return new Integer(index);
                    }
                };
                future = executorService.submit(new ExecTask(implObj,order));
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

    /**
     * 方案1
     */
    @Test
    public void volatileWhileImplTest() {

        this.coreImpl(VolatileWhileImpl.class);

    }

    /**
     * 方案2
     */
    @Test
    public void atomicIntegerWhileImplTest() {

        this.coreImpl(AtomicIntegerWhileImpl.class);

    }

    /**
     * 有问题
     */
    @Test
    public void unsafeWhileImplTest() {
        UnsafeWhileImpl unsafeWhile = new UnsafeWhileImpl();

    }

    /**
     * 方案3
     */
    @Test
    public void arrayBlockingQueueTest() {
        this.coreImpl(ArrayBlockingQueueImpl.class);
    }

    /**
     * 方案4
     */
    @Test
    public void countDownLatchImplTest() {
        this.coreImpl(CountDownLatchImpl.class);
    }

    /**
     * 方案5
     */
    @Test
    public void volatileLockConditionImplTest() {
        this.coreImpl(VolatileLockConditionImpl.class);
    }

    /**
     * 方案6
     */
    @Test
    public void volatileSyncWaitNotifyImplTest() {
        this.coreImpl(VolatileSyncWaitNotifyImpl.class);
    }

    /**
     * 方案7
     */
    @Test
    public void volatileLockSupportImplTest() {
        this.coreImpl(VolatileLockSupportImpl.class);
    }

    @Test
    public void pipedStreamImplTest() {
        this.coreImpl(OneByOnePipedStreamImpl.class);
    }

    class ExecTask implements Runnable {
        private RunOneByOneApi runOneByOneApi;
        private ThreadLocal<Integer> order;

        ExecTask(RunOneByOneApi runOneByOneApi,ThreadLocal order) {
            this.runOneByOneApi = runOneByOneApi;
            this.order = order;

        }

        @Override
        public void run() {
            if(order.get() == 1) {
                try {
                    runOneByOneApi.first(firstTask);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if(order.get() == 2) {
                try {
                    runOneByOneApi.second(secondTask);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if(order.get() == 3) {
                try {
                    runOneByOneApi.third(thirdTask);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
