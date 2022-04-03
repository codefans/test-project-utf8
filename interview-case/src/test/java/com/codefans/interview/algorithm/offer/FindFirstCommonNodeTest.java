/**
 * Copyright (C), 2015-2021, 京东
 * FileName: FindFirstCommonNodeTest
 * Author:   codefans
 * Date:     2021/5/21 15:13
 * Description: 查询链表第一个公共节点
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Test;

/**
 *
 * 查询链表第一个公共节点
 *
 * @author: codefans
 * @Date: 2021/05/21 15:13
 * @since: 1.0.0
 */
public class FindFirstCommonNodeTest {

    @Test
    public void findFirstCommonNodeTest() {

        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);

        ListNode commonNode = new ListNode(6);
        commonNode.next = new ListNode(7);
        commonNode.next.next = new ListNode(8);

        headA.next.next = commonNode;

        ListNode headB = new ListNode(2);
        headB.next = new ListNode(4);
        headB.next.next = commonNode;

        ListNode findCommonNode = findFirstCommonNode.findCommonNode3(headA, headB);
        ListNodeUtils.print(headA);
        ListNodeUtils.print(headB);
        System.out.println("commonNode.value=" + findCommonNode.val);
    }
}