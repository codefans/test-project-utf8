/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ListNodeSplit
 * Author:   caishengzhi
 * Date:     2021/5/26 14:07
 * Description: 链表拆分
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.ListNode;

/**
 *
 * 链表拆分
 *
 * @author: codefans
 * @Date: 2021/05/26 14:07
 * @since: 1.0.0
 */
public class ListNodeSplit {

    /**
     * 拆分链表, 返回奇数节点组成的链表
     * @param head
     * @return
     */
    ListNode spiltOdd(ListNode head) {
        ListNode newHead = head;
        while(head != null) {
            ListNode next = head.next;
            if(next != null && next.next != null) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return newHead;
    }

    /**
     * 拆分链表, 返回偶数节点组成的链表
     * @param head
     * @return
     */
    ListNode spiltEven(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            if(newHead == null) {
                newHead = head.next;
            } else {
                ListNode next = head.next;
                if (next != null && next.next != null) {
                    head.next = next.next;
                } else {
                    head.next = null;
                }
            }
            head = head.next;
        }
        return newHead;
    }

}