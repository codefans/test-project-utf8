package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.reusablecode.datastructure.ListNode;

/**
 * @Author: codefans
 * @Date: 2019-07-25 1:27
 *
 * 算法思路：
 *    1.将当前节点之后的节点的值依次往前挪
 *    2.去掉最后一个节点: 将倒数第二个节点的next指向null
 *
 */

public class No237DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        ListNode cur = node;
        if(cur != null) {
            ListNode next = cur.next;
            cur.val = next.val;
            cur.next = next.next;
        }
    }

    public void deleteNode02(ListNode node) {
        ListNode next = node;
        while(next != null) {
            if(next.next != null) {
                next.val = next.next.val;
                if(next.next.next == null) {
                    next.next = null;
                    next = null;
                } else {
                    next = next.next;
                }

            }
        }
    }
}
