package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;

/**
 * @Author: codefans
 * @Date: 2019-07-30 22:30
 */

public class No82RemoveDuplicatesFromSortedListII {

    /**
     * 思路：
     *     当前节点和下一个节点比，如果值相同，则删除当前节点（将前一个节点的next指向下一个节点，即pre.next=next）。
     *     所以如果前两个值相同，为了删除第一个节点，我们新增了一个值为-1的首节点first。这样原来的第一个节点就变成了cur。
     *
     *     相邻的多个相同值的节点，由于是从前往后删，相同值里面的最后一个节点，和它下一个节点的值是不同的，所以这个特殊节点的删除逻辑和其他节点不同。
     *     需要新增一个lastVal变量，记录最后一个节点的值，这样就能删除相同值的最后一个节点了。
     *
     *     while循环结束后，要删除最后一个节点，也是只能根据lastVal值去判断。
     *
     * 漏掉一组单元测试未覆盖到，导致没通过：
     *    [-1,0,0,0,0,3,3]
     * 原因是：
     *    开始的时候把lastVal的值设置为-1，和这组数据的第一个元素相同了，所以导致了错误。将lastVal设置为-999999999就好了。
     *
     * 性能
     *    Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
     *    Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
     *
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
                return null;
            } else {
                return head;
            }
        }
        ListNode first = new ListNode(-1);
        first.next = head;

        ListNode pre = first;
        ListNode cur = head;
        ListNode next = head.next;
        int lastVal = -999999999;
        while(next != null) {
            if(cur.val == next.val || cur.val == lastVal) {
                pre.next = next;
                lastVal = cur.val;
            } else {
                pre = cur;
            }
            cur = next;
            next = next.next;
        }
        if(cur.val == lastVal) {
            pre.next = null;
        }
        return first.next;
    }

}
