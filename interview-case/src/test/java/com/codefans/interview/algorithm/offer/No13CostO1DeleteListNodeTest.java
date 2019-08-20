package com.codefans.interview.algorithm.offer;

import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-08-20 23:08
 */

public class No13CostO1DeleteListNodeTest {

    private ListNode head;
    private ListNode toDel;

    private No13CostO1DeleteListNode deleteListNode;

    @Before
    public void before() {



        deleteListNode = new No13CostO1DeleteListNode();

    }

    @Test
    public void firstNodeDelTest() {

        toDel = new ListNode(1);
        head = toDel;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNodeUtils.print(head);
        ListNode result = deleteListNode.delete(head, toDel);
        ListNodeUtils.print(result);

    }

    @Test
    public void midNodeDelTest() {

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        toDel = new ListNode(4);
        head.next.next.next = toDel;
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNodeUtils.print(head);
        ListNode result = deleteListNode.delete(head, toDel);
        ListNodeUtils.print(result);

    }

    @Test
    public void tailNodeDelTest() {

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        toDel = new ListNode(6);
        head.next.next.next.next.next = toDel;

        ListNodeUtils.print(head);
        ListNode result = deleteListNode.delete(head, toDel);
        ListNodeUtils.print(result);

    }

}
