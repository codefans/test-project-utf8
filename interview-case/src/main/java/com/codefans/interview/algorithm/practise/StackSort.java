/**
 * Copyright (C), 2015-2021, 京东
 * FileName: StackSort
 * Author:   codefans
 * Date:     2021/5/26 16:52
 * Description: 栈排序
 */
package com.codefans.interview.algorithm.practise;


import java.util.Stack;

/**
 *
 * 栈排序
 * 用两个栈实现排序功能
 * @author: codefans
 * @Date: 2021/05/26 16:52
 * @since: 1.0.0
 */
public class StackSort {

    /**
     *
     * @param data
     * @return
     */
    public Stack<Integer> stackSort(Stack<Integer> data) {
        Stack<Integer> tmp = new Stack<Integer>();
        while(!data.isEmpty()) {
            int topData = data.pop();
            while(!tmp.isEmpty() && topData > tmp.peek()) {
                data.push(tmp.pop());
            }
            tmp.push(topData);
        }
        return tmp;
    }

}
