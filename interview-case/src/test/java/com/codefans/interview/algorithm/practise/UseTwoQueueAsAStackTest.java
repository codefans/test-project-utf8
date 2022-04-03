/**
 * Copyright (C), 2015-2021, 京东
 * FileName: UseTwoQueueAsAStackTest
 * Author:   codefans
 * Date:     2021/9/24 11:38
 * Description: 用两个队列模拟栈-测试类
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.offer.UseTwoQueueAsAStack;
import com.codefans.interview.algorithm.offer.UseTwoStackAsAQueue;
import org.junit.Test;

/**
 *
 * 用两个队列模拟栈-测试类
 *
 * @author: codefans
 * @Date: 2021/09/24 11:38
 * @since: 1.0.0
 */
public class UseTwoQueueAsAStackTest {

    @Test
    public void useTwoStackAsAQueueTest() {

        UseTwoQueueAsAStack obj = new UseTwoQueueAsAStack();
        int count = 10;
        for(int i = 0; i < count; i ++) {
            obj.push(i);
            System.out.println("push[" + i + "]");
        }

        for(int i = 0; i < count; i ++) {
            int headValue = obj.pop();
            System.out.println("pop[" + headValue + "]");
        }

    }

}