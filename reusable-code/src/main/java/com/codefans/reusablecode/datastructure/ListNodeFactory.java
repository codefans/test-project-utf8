package com.codefans.reusablecode.datastructure;

/**
 * @author: codefans
 * @date: 2019-07-14 21:50
 */
public class ListNodeFactory {

    public static ListNode createOneNode() {
        return createListNode(1);
    }

    public static ListNode createTwoNode() {
        return createListNode(2);
    }

    public static ListNode createThreeNode() {
        return createListNode(3);
    }

    public static ListNode createFourNode() {
        return createListNode(4);
    }

    public static ListNode createFiveNode() {
        return createListNode(5);
    }

    public static ListNode createSixNode() {
        return createListNode(6);
    }

    public static ListNode createListNode(int len) {
        ListNode head = null;
        ListNode next = null;
        if(len > 0) {
            for(int i = 1; i <= len; i ++) {
                if(i == 1) {
                    head = new ListNode(i);
                    next = head;
                } else {
                    next.next = new ListNode(i);
                    next = next.next;
                }
            }
        }
        return head;
    }

    public static ListNode createByArr(int... valArr) {
        ListNode head = null;
        ListNode current = null;
        int len = valArr == null ? 0 : valArr.length;
        for(int i = 0; i < len; i ++) {
            if(i == 0) {
                head = new ListNode(valArr[i]);
                current = head;
            } else {
                current.next = new ListNode(valArr[i]);
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 创建一个循环链表
     * @return
     */
    public static ListNode createCycleListNode() {
        ListNode head = new ListNode(1);
        ListNode mid = new ListNode(2);
        ListNode tail = new ListNode(3);
        head.next = mid;
        mid.next = tail;
        tail.next = head;
        return head;
    }

}
