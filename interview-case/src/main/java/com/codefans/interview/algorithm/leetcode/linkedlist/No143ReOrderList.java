/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No143ReOrderList
 * Author:   caishengzhi
 * Date:     2021/5/27 15:17
 * Description: 重排链表
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.reusablecode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 重排链表
 *
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 链接：https://leetcode-cn.com/problems/reorder-list
 *
 * @author: codefans
 * @Date: 2021/05/27 15:17
 * @since: 1.0.0
 */
public class No143ReOrderList {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了81.31%的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了24.40%的用户
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     */
    public void reorderList(ListNode head) {
        /**
         * 如果只有1个或者2个节点, 则不需要重排, 因为重排后也还是原来的样子
         */
        if(head.next == null || head.next.next == null) {
            return;
        }

        /**
         * 从中间切割链表
         */
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        /**
         * 断开中间指针
         */
        ListNode preNode = slow;
        slow = slow.next;
        preNode.next = null;

//        System.out.println("prefixSubList:");
//        ListNodeUtils.print(head);
//        System.out.println("slow:");
//        ListNodeUtils.print(slow);

        /**
         * 反转后面一半的链表
         */
        ListNode revertSlow = this.revert(slow);
//        System.out.println("revertSlow:");
//        ListNodeUtils.print(revertSlow);

        /**
         * 穿插合并链表
         */
        this.merge(head, revertSlow);

    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode revert(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 穿插合并链表
     * @param head1
     * @param head2
     */
    private void merge(ListNode head1, ListNode head2) {
        while(head1 != null && head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     */
    public void reorderList2(ListNode head) {
        /**
         * 如果只有1个或者2个节点, 则不需要重排, 因为重排后也还是原来的样子
         */
        if(head.next == null || head.next.next == null) {
            return;
        }

        List<ListNode> nodeList = new ArrayList<>();
        while(head != null) {
            nodeList.add(head);
            head = head.next;
        }

        int i = 0;
        int j = nodeList.size() - 1;
        while(i < j) {
            nodeList.get(i).next = nodeList.get(j);
            i++;
            if(i == j) {
                break;
            }
            nodeList.get(j).next = nodeList.get(i);
            j--;
        }
        nodeList.get(i).next = null;

    }


}
