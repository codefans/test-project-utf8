/**
 * Copyright (C), 2015-2020, 京东
 * FileName: ConcurrencyTest
 * Author:   codefans
 * Date:     2020/4/14 9:22
 * Description: 并发测试
 */
package com.codefans.basicjava.concurrent;


/**
 *
 * 并发测试
 *
 * @author: codefans
 * @Date: 2020/04/14 09:22
 * @since: 1.0.0
 */
public class ShareDataModifyConcurrencyProblemTest {

    static Obj obj = new Obj();

    public static void main(String[] args) throws InterruptedException {

        System.out.println("obj before=" + obj.getData());
        ThreadTask task1 = new ThreadTask(obj, "add");
        ThreadTask task2 = new ThreadTask(obj, "minus");
        task1.start();
        task2.start();

//        for(int i = 0; ; i ++) {
//            System.out.println("obj=" + obj.getData());
//        }

        task1.join();
        task2.join();

        System.out.println("obj after=" + obj.getData());

    }

}

class ThreadTask extends Thread {
    private String operation;
    private Obj obj;
    ThreadTask(Obj obj, String operation) {
        this.obj = obj;
        this.operation = operation;
    }
    @Override
    public void run() {
        int nums = 100000;
        if("add".equals(operation)) {
            while(nums > 0) {
                obj.add();
                nums--;
            }
        } else if("minus".equals(operation)) {
            while(nums > 0) {
                obj.minus();
                nums--;
            }
        }
    }

}

class Obj {

    int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    /**
     * 没有synchronized就会有并发问题
     */
    public synchronized void add() {
        data++;
//        System.out.println("add data=" + data);
    }

    /**
     * 没有synchronized就会有并发问题
     */
    public synchronized void minus() {
        data--;
//        System.out.println("minus data=" + data);
    }

}