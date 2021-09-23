/**
 * Copyright (C), 2015-2021, 京东
 * FileName: LinkedListTest
 * Author:   caishengzhi
 * Date:     2021/9/23 19:47
 * Description: LinkedList测试类
 */
package com.codefans.basicjava.util;


import org.junit.Test;

import java.util.LinkedList;

/**
 *
 * LinkedList测试类
 *
 * @author: codefans
 * @Date: 2021/09/23 19:47
 * @since: 1.0.0
 */
public class LinkedListTest {

    /**
     * offer()方法-添加到队尾
     * pop()方法-移除队首元素
     */
    @Test
    public void useLinkedListAsQueueTest() {

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("hello");
        queue.offer("world");
        queue.offer("zhangsan");
        queue.offer("lisi");
        queue.offer("wangwu");
        String topItem = queue.pop(); //移除hello, 先进先出
        System.out.println(topItem);

    }

    /**
     *
     */
    @Test
    public void useLinkedListAsStackTest() {

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("hello");
        queue.offer("world");
        queue.offer("zhangsan");
        queue.offer("lisi");
        queue.offer("wangwu");
        String topItem = queue.removeLast(); //移除wangwu, 后进先出
        System.out.println(topItem);

    }

}