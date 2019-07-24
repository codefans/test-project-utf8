package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;

/**
 * @Author: codefans
 * @Date: 2019-07-25 1:27
 *
 * 算法思路：
 *    将当前节点之后的节点的值依次往前挪
 *
 */

public class No237DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
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
