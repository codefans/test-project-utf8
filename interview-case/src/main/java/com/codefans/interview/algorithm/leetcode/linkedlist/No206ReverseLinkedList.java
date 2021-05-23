package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;

/**
 * @Author: codefans
 * @Date: 2019-07-24 23:02
 *
 * 算法描述：
 *    1.定义两个节点pre前节点和next后节点
 *    2.把头结点赋值给pre前节点,把头结点的下一个节点赋值给next后节点,把pre的next置为null
 *    3.如果head不为空,next走到head.next的位置,head.next指向pre,然后前节点pre往前走到head的位置,head头结点往前走到next后节点的位置
 *
 */

public class No206ReverseLinkedList {
    public ListNode reverseListIteratively(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode pre = null;
        pre = head;
        head = head.next;
        pre.next = null;

        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        boolean isFirst = true;
        while(head != null) {
            if(isFirst) {
                pre = head;
                head = head.next;
                pre.next = null;
                /**
                 * 第一次 忘了把isFirst设置为false
                 */
                isFirst = false;
            } else {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
        }
        return pre;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseListIterator(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * @param head
     * @return
     */
    public ListNode reverseListRecursively(ListNode head, ListNode newHead) {
        if(head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
        return reverseListRecursively(head, newHead);
    }




}
