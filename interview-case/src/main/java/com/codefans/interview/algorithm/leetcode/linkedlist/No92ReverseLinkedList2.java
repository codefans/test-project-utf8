/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No92ReverseLinkedList2
 * Author:   caishengzhi
 * Date:     2021/5/12 17:33
 * Description: leetcode第92题反转链表2-中等难度
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.interview.algorithm.common.ListNode;

/**
 *
 * leetcode第92题反转链表2-中等难度
 *
 * @author: codefans
 * @Date: 2021/05/12 17:33
 * @since: 1.0.0
 */
public class No92ReverseLinkedList2 {

    /**
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = null;
        ListNode originHead = head;
        int index = 0;
        while(head != null) {
            if(index < left) {
                head = head.next;
            } else {
                ListNode next = head.next;
                if(index < right) {
                    head.next = newHead;
                    newHead = head;
                    head = next;
                } else {
                    newHead.next = next;
                }
            }
            index ++;
        }
        return originHead;
    }

}