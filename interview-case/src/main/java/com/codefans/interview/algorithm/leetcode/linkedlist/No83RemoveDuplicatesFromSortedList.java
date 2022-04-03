package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.reusablecode.datastructure.ListNode;

/**
 * @Author: codefans
 * @Date: 2019-07-30 21:56
 */

public class No83RemoveDuplicatesFromSortedList {

    /**
     * 思路：
     *    如果当前节点和前一个元素值相同，则删除当前节点（将前一个元素的next指向下一个元素），然后当前curr走到下一个节点，下一个节点next走到下下个节点；
     *    如果当前节点和前一个元素值不同，则将前一个节点pre走到当前节点curr的位置，当前节点curr走到下一个节点next的位置，下一个节点next走到下下个节点next.next的位置；
     *
     * Runtime: 0 ms, faster than 100.00% .
     * Memory Usage: 36.2 MB, less than 100.00% .
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        if(head.next.next == null) {
            if(head.val == head.next.val) {
                head.next = null;
                return head;
            } else {
                return head;
            }
        }
        ListNode pre = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        while(next != null) {
            if(pre.val == curr.val) {
                pre.next = next;
            } else {
                pre = curr;
            }
            curr = next;
            next = next.next;
        }

        if(pre.val == curr.val) {
            pre.next = null;
        }

        return head;

    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode lastNode = null;
        int lastVal = -200;
        while(head != null) {
            if(lastVal == head.val) {
                if(head.next != null) {
                    head.val = head.next.val;
                    head.next = head.next.next;
                } else {
                    head = head.next;
                    lastNode.next = null;
//                    System.out.println("head.next==null, lastNode.val=" + lastNode.val + ", head.val=" + head.val);
//                    break;
                }
            } else {
                lastNode = head;
                System.out.println("lastNode.val=" + lastNode.val);
                lastVal = head.val;
                head = head.next;
            }

        }

        return newHead;
    }





}
