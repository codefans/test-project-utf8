/**
 * Copyright (C), 2015-2021, 京东
 * FileName: UseTwoStackAsAQueueTest
 * Author:   caishengzhi
 * Date:     2021/9/24 10:41
 * Description:
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.offer.UseTwoStackAsAQueue;
import org.junit.Test;

/**
 * 用两个栈实现一个队列
 * @author: codefans
 * @Date: 2021/09/24 10:41
 * @since: 1.0.0
 */
public class UseTwoStackAsAQueueTest {

    @Test
    public void useTwoStackAsAQueueTest() {

        UseTwoStackAsAQueue obj = new UseTwoStackAsAQueue();
        int count = 10;
        for(int i = 0; i < count; i ++) {
            obj.appendTail(i);
            int headValue = obj.deleteHead();
            System.out.println("push[" + i + "], deleteHead[" + headValue + "]");
        }

    }

}