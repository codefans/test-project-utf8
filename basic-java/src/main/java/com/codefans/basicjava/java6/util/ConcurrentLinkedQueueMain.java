package com.codefans.basicjava.java6.util;

import com.codefans.basicjava.util.CollectionHelper;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: codefans
 * @date: 2019-08-23 10:41
 */
public class ConcurrentLinkedQueueMain {

    public static void main(String[] args) {


        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        int num = 20;
        for(int i = 0; i < num; i ++) {
            queue.add("str_" + i);
        }

        CollectionHelper.print(queue);

        /**
         * 移除并返回头结点
         */
        queue.poll();
        System.out.println("remove first:");
        CollectionHelper.print(queue);

        /**
         * 删除某个结点
         */
        queue.remove("str_5");
        System.out.println("after remove last:");
        CollectionHelper.print(queue);

        /**
         * 在队尾添加元素
         */
        queue.offer("hello world");
        System.out.println("after offer last:");
        CollectionHelper.print(queue);

    }




}
