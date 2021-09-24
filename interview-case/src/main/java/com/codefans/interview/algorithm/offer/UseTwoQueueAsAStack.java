/**
 * Copyright (C), 2015-2021, 京东
 * FileName: UseTwoQueueAsAStack
 * Author:   caishengzhi
 * Date:     2021/9/24 11:34
 * Description: 用两个队列模拟栈
 */
package com.codefans.interview.algorithm.offer;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 用两个队列模拟栈
 *
 * @author: codefans
 * @Date: 2021/09/24 11:34
 * @since: 1.0.0
 */
public class UseTwoQueueAsAStack {

    Queue<Integer> queueOne = new LinkedList<>();
    Queue<Integer> queueTwo = new LinkedList<>();

    public void push(int value) {
        queueOne.offer(value);
    }

    public int pop() {
        int headVal = -1;
        if(queueTwo.size() == 0) {
            while(!queueOne.isEmpty()) {
                queueTwo.offer(queueOne.poll());
            }
        }
        if(queueTwo.size() > 0) {
            headVal = queueTwo.poll();
        }
        return headVal;
    }

}