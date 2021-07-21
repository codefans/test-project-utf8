package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
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

    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;
        while(twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return oneStep;
    }

}
