/**
 * Copyright (C), 2015-2021, 京东
 * FileName: MergeTwoSortedLinkedList
 * Author:   caishengzhi
 * Date:     2021/5/21 10:52
 * Description: 合并两个有序链表
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.ListNode;

/**
 *
 * 合并两个有序链表
 *
 * @author: codefans
 * @Date: 2021/05/21 10:52
 * @since: 1.0.0
 */
public class MergeTwoSortedLinkedList {

    /**
     * 例如：
     * l1: 1->3->5
     * l2: 2->4->6
     * 合并后：
     *     1->2->3->4->5->6
     * 第一次写，这个出现了死循环
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resListNode = null;
        ListNode current = null;
        ListNode newNode = null;
        int val01;
        int val02;

        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                val01 = l1.val;
                val02 = l2.val;
                if (val01 > val02) {
                    newNode = new ListNode(val02);
                    l2 = l2 == null ? null : l2.next;
                } else {
                    newNode = new ListNode(val01);
                    l1 = l1 == null ? null : l1.next;
                }
            } else if(l1 == null && l2 != null) {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            } else if(l1 != null && l2 == null) {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            if(resListNode == null) {
                resListNode = newNode;
                current = resListNode;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }

        return resListNode;
    }

    /**
     * 例如：
     * l1: 1->3->5
     * l2: 2->4->6
     * 合并后：
     *     1->2->3->4->5->6
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode resListNode = new ListNode(0);
        ListNode current = resListNode;
        while(l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        if(l1 != null) {
            current.next = l1;
        } else if(l2 != null) {
            current.next = l2;
        }
        return resListNode.next;
    }

}