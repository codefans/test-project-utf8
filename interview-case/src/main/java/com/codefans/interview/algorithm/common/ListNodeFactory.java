package com.codefans.interview.algorithm.common;

/**
 * @author: codefans
 * @date: 2019-07-14 21:50
 */
public class ListNodeFactory {

    public static ListNode createOneNode() {
        ListNode head = new ListNode(1);
        return head;
    }

    public static ListNode createTwoNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        return head;
    }

    public static ListNode createThreeNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        return head;
    }

    public static ListNode createFourNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        return head;
    }

    public static ListNode createFiveNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    public static ListNode createSixNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        return head;
    }


}
