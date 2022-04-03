/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No19RemoveNthNodeFromEndOfList
 * Author:   caishengzhi
 * Date:     2021/7/20 17:02
 * Description: 删除链表的倒数第 N 个结点
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.reusablecode.datastructure.ListNode;

/**
 *
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author: codefans
 * @Date: 2021/07/20 17:02
 * @since: 1.0.0
 */
public class No19RemoveNthNodeFromEndOfList {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 进阶：你能尝试使用一趟扫描实现吗？
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = null;
        if(head.next == null && n >= 1) {
            return newHead;
        }
        newHead = head;
        int len = getLen(head);
        int moveStep = len - n;
        ListNode cur = head;
        ListNode pre = null;
        while(moveStep > 0 && cur != null) {
            pre = cur;
            cur = cur.next;
            moveStep--;
        }
        System.out.println("cur.val=" + cur.val);
        if(cur != null && cur.next != null) {
            cur.val = cur.next.val;
            cur.next = cur.next.next;
        }
        if(n == 1) {
            pre.next = null;
        }
        return newHead;
    }

    public int getLen(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
