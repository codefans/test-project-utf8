/**
 * Copyright (C), 2015-2021, 京东
 * FileName: StackSortTest
 * Author:   caishengzhi
 * Date:     2021/5/26 16:57
 * Description: 栈排序测试类
 */
package com.codefans.interview.algorithm.practise;


import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * 栈排序测试类
 *
 * @author: codefans
 * @Date: 2021/05/26 16:57
 * @since: 1.0.0
 */
public class StackSortTest {

    /**
     *
     */
    private StackSort stackSort;

    @Test
    public void stackSortTest() {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);

        stackSort = new StackSort();
        Stack<Integer> result = stackSort.stackSort(stack);
        Iterator<Integer> iter = result.iterator();
        while(iter.hasNext()) {
            System.out.print(result.pop() + ",");
        }
    }

}