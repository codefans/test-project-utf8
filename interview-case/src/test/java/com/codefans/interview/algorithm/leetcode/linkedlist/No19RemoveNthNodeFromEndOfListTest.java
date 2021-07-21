/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No19RemoveNthNodeFromEndOfListTest
 * Author:   caishengzhi
 * Date:     2021/7/20 17:32
 * Description: 删除链表的倒数第N个节点测试
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 删除链表的倒数第N个节点测试
 *
 * @author: codefans
 * @Date: 2021/07/20 17:32
 * @since: 1.0.0
 */
public class No19RemoveNthNodeFromEndOfListTest {

    private No19RemoveNthNodeFromEndOfList no19;

    @Before
    public void before() {
        no19 = new No19RemoveNthNodeFromEndOfList();
    }

    @Test
    public void removeNthFromEndTest() {

        int unitTestCount = 10;
        for(int i = 1; i <= unitTestCount; i ++) {
            ListNode head = ListNodeFactory.createListNode(i);
            int n = 1;
            ListNode newHead = no19.removeNthFromEnd(head, n);
            System.out.println("共[" + i + "]个节点, 删除倒数第[" + n + "]个节点后，链表如下：");
            ListNodeUtils.print(newHead);
        }

    }

}