package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;

/**
 * @author: codefans
 * @date: 2019-07-14 21:46
 */
public class No876MiddleOfTheLinkedList {

    /**
     * 思路：
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if(head.next == null) {
            return head;
        }
        if(head.next.next == null) {
            return head.next;
        }
        ListNode twoStep = head;
        while(head.next != null) {
            if(twoStep.next != null) {
                twoStep = twoStep.next;
                if(twoStep.next != null) {
                    twoStep = twoStep.next;
                } else {
                    head = head.next;
                    break;
                }
            } else {
                break;
            }
            head = head.next;
        }
        return head;
    }

}
