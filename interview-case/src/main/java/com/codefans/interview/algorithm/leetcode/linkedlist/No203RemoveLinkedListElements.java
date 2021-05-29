package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;

/**
 * @Author: codefans
 * @Date: 2019-07-31 21:54
 */

public class No203RemoveLinkedListElements {

    /**
     * 思路：
     *
     * Runtime: 1 ms, faster than 98.54% of Java online submissions for Remove Linked List Elements.
     * Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Remove Linked List Elements.
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            if(head.val == val) {
                return null;
            } else {
                return head;
            }
        }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null) {
            if(cur.val == val) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
            next = next.next;
        }
        if(pre.next.val == val) {
            pre.next = null;
        }
        return first.next;
    }

    /**
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode lastNode = head;
        while(head != null) {
            if(head.val == val) {
                if(head.next != null) {
                    head.val = head.next.val;
                    head.next = head.next.next;
                } else {
                    lastNode.next = null;
                    head = head.next;
                }
            } else {
                lastNode = head;
                head = head.next;
            }
        }
        if(newHead.val == val) {
            newHead = null;
        }
        return newHead;
    }

}
