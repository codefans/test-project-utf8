package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-07-24 23:02
 */

public class No206ReverseLinkedListTest {

    private ListNode node;

    @Before
    public void before() {
        node = ListNodeFactory.createFiveNode();
    }

    @Test
    public void reverseListTest() {
        ListNodeUtils.print(node);
        No206ReverseLinkedList no206ReverseLinkedList = new No206ReverseLinkedList();
//        ListNode resultNode = no206ReverseLinkedList.reverseListIteratively(node);
//        ListNode resultNode = no206ReverseLinkedList.reverseList2(node);
        ListNode resultNode = no206ReverseLinkedList.reverseListRecursively(node);
        ListNodeUtils.print(resultNode);
    }

}
