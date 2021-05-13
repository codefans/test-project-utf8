/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No92ReverseLinkedList2Test
 * Author:   caishengzhi
 * Date:     2021/5/12 18:23
 * Description: No92ReverseLinkedList2测试类
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * No92ReverseLinkedList2测试类
 *
 * @author: codefans
 * @Date: 2021/05/12 18:23
 * @since: 1.0.0
 */
public class No92ReverseLinkedList2Test {

    private ListNode node;

    @Before
    public void before() {
        node = ListNodeFactory.createListNode(6);
    }

    @Test
    public void reverseListTest() {
        No92ReverseLinkedList2 no92ReverseLinkedList2 = new No92ReverseLinkedList2();
        ListNodeUtils.print(no92ReverseLinkedList2.reverseBetween(node, 2,4));
    }


}