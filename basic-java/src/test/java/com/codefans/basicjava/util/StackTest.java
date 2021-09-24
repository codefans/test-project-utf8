/**
 * Copyright (C), 2015-2021, 京东
 * FileName: StackTest
 * Author:   caishengzhi
 * Date:     2021/9/24 11:28
 * Description:
 */
package com.codefans.basicjava.util;


import org.junit.Test;

import java.util.Stack;

/**
 * 栈的测试类
 * @author: codefans
 * @Date: 2021/09/24 11:28
 * @since: 1.0.0
 */
public class StackTest {

    /**
     * 栈的遍历要特别小心，这种遍历方式，无法将所有元素遍历到。
     * 这个例子中，弹出两个元素后，i=2，stack.size()=2，这样最后两个元素无法遍历到。
     */
    @Test
    public void stackIteratorWrongWayTest() {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        for(int i = 0; i < stack.size(); i ++) {
            System.out.println(stack.pop());
        }

        System.out.println("stack.size()=" + stack.size());

    }

    /**
     * 遍历栈的正确姿势
     */
    @Test
    public void stackIteratorRightWayTest() {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("stack.size()=" + stack.size());

    }

}