/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No143ReOrderListTest
 * Author:   caishengzhi
 * Date:     2021/5/27 15:19
 * Description: 重排链表测试类
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Test;

/**
 *
 * 重排链表测试类
 *
 * @author: codefans
 * @Date: 2021/05/27 15:19
 * @since: 1.0.0
 */
public class No143ReOrderListTest {

    @Test
    public void reorderListTest() {

        No143ReOrderList reOrderList = new No143ReOrderList();
//        ListNode head = ListNodeFactory.createByArr(1);
//        ListNode head = ListNodeFactory.createByArr(1,2);
//        ListNode head = ListNodeFactory.createByArr(1,2,3);
//        ListNode head = ListNodeFactory.createByArr(1,2,3,4);
//        ListNode head = ListNodeFactory.createByArr(1,2,3,4,5);
        ListNode head = ListNodeFactory.createByArr(1,2,3,4,5,6);
        System.out.println("重排前：");
        ListNodeUtils.print(head);

//        reOrderList.reorderList(head);
        reOrderList.reorderList2(head);

        System.out.println("重排后：");
        ListNodeUtils.print(head);
    }
}