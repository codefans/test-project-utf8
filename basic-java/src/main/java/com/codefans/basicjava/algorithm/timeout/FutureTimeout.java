package com.codefans.basicjava.algorithm.timeout;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author: ShengzhiCai
 * @Date: 2018-05-21 21:04
 */

public class FutureTimeout {

    public static void main(String[] args) {
        FutureTimeout futureTimeout = new FutureTimeout();
        futureTimeout.timeoutTest();
    }

    public void timeoutTest() {

//        this.callableTimeoutTest();
        this.runnableTimeoutTest();


    }


    public void callableTimeoutTest() {

        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {

                //暂停10s
//                Thread.sleep(10 * 1000);
                long timeout = 10 * 1000;
                long start = System.currentTimeMillis();
                while(true) {

                    if(System.currentTimeMillis() - start > timeout) {
                        break;
                    }
                    Thread.sleep(1000);
                    System.out.println(new Date());

                }

                System.out.println("return....");
                return "resultString";
            }
        };

        try {


//            ExecutorService executorService = Executors.newSingleThreadExecutor();
            ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            Future<String> resultFuture = executorService.submit(task);
            long timeout = 5 * 1000;
            //5秒后只是线程返回,任务方法还在执行
            String result = resultFuture.get(timeout, TimeUnit.MILLISECONDS);
            System.out.println("result:" + result);



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }

    public void runnableTimeoutTest() {

        Runnable task = new Runnable() {

            @Override
            public void run() {

                try {
                    //暂停10s
//                Thread.sleep(10 * 1000);
                    long timeout = 3 * 1000;
                    long start = System.currentTimeMillis();
                    while(true) {

                        if(System.currentTimeMillis() - start > timeout) {
                            break;
                        }
                        Thread.sleep(1000);
                        System.out.println(new Date());

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("return....");
            }

            public String getResult() {

                return "";
            }

        };

        try {


            ExecutorService executorService = Executors.newSingleThreadExecutor();
            String resultObj = new String();
            Future<String> resultFuture = executorService.submit(task, resultObj);
            long timeout = 5 * 1000;
            //5秒后只是线程返回,任务方法还在执行
            String result = resultFuture.get(timeout, TimeUnit.MILLISECONDS);
            System.out.println("result:" + result);
            System.out.println("resultObj:" + resultObj);



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

}
