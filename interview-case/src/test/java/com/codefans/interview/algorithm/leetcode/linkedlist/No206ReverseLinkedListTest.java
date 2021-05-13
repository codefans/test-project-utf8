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
//        node = ListNodeFactory.createFiveNode();
        node = ListNodeFactory.createListNode(10);
    }

    @Test
    public void createListNodeTest() {
        ListNodeUtils.print(ListNodeFactory.createOneNode());
        ListNodeUtils.print(ListNodeFactory.createTwoNode());
        ListNodeUtils.print(ListNodeFactory.createThreeNode());
        ListNodeUtils.print(ListNodeFactory.createFourNode());
        ListNodeUtils.print(ListNodeFactory.createFiveNode());
        ListNodeUtils.print(ListNodeFactory.createSixNode());
    }

    @Test
    public void reverseListTest() {
        ListNodeUtils.print(node);
        No206ReverseLinkedList no206ReverseLinkedList = new No206ReverseLinkedList();
        ListNode newHead = null;
//        ListNode resultNode = no206ReverseLinkedList.reverseListRecursively(node, newHead);
        ListNode resultNode = no206ReverseLinkedList.reverseListIterator(node);
        ListNodeUtils.print(resultNode);
    }

}
