/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No2AddTwoNumbersTest
 * Author:   caishengzhi
 * Date:     2021/5/20 9:50
 * Description: 两数相加
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Test;

/**
 *
 * 两数相加
 *
 * @author: codefans
 * @Date: 2021/05/20 09:50
 * @since: 1.0.0
 */
public class No2AddTwoNumbersTest {

    @Test
    public void addTwoNumbersTest() {

//        [9,9,9,9,9,9,9]
//        [9,9,9,9]

        No2AddTwoNumbers no2AddTwoNumbers = new No2AddTwoNumbers();
//        ListNode l1 = ListNodeFactory.createListNode(2, 4, 3);
        ListNode l1 = ListNodeFactory.createListNode(9,9,9,9,9,9,9);
        System.out.println("链表l1:");
        ListNodeUtils.print(l1);
//        ListNode l2 = ListNodeFactory.createListNode(5, 6, 4);
        ListNode l2 = ListNodeFactory.createListNode(9,9,9,9);
        System.out.println("链表l2:");
        ListNodeUtils.print(l2);
        ListNode l3 = no2AddTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println("相加后链表l3:");
        ListNodeUtils.print(l3);

    }

}