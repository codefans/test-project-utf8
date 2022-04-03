/**
 * Copyright (C), 2015-2021, 京东
 * FileName: UseTwoStackAsAQueue
 * Author:   codefans
 * Date:     2021/9/24 10:39
 * Description: 用两个栈实现队列
 */
package com.codefans.interview.algorithm.offer;


import java.util.Stack;

/**
 *
 * 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 * 栈：后进先出
 * 队列：先进先出
 *
 * @author: codefans
 * @Date: 2021/09/24 10:39
 * @since: 1.0.0
 */
public class UseTwoStackAsAQueue {

    private Stack<Integer> stackOne = new Stack<Integer>();
    private Stack<Integer> stackTwo = new Stack<Integer>();

    public UseTwoStackAsAQueue() {

    }

    public void appendTail(int value) {
        stackOne.push(value);
    }

    public int deleteHead() {
        int headVal = -1;
        if(stackTwo.size() == 0) {
            while(!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
        if(stackTwo.size() > 0) {
            headVal = stackTwo.pop();
        }
        return headVal;
    }

}
