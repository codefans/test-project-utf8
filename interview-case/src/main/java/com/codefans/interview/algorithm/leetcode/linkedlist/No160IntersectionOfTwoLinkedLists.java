package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: codefans
 * @Date: 2019-09-12 23:00
 */

public class No160IntersectionOfTwoLinkedLists {

    /**
     * Runtime: 1 ms, faster than 98.86% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 39.7 MB, less than 12.14% of Java online submissions for Intersection of Two Linked Lists.
     * 思路
     *    1.遍历两个链表,得到两个链表的长度、两个链表的长度差diff;
     *    2.较长的链表先走diff步,然后两个链表一起完后走,第一个相等的节点,即是两个链表相交的第一个节点.
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode res = null;

        int lenA = 0;
        ListNode nodeA = headA;
        while(nodeA != null) {
            nodeA = nodeA.next;
            lenA++;
        }
        int lenB = 0;
        ListNode nodeB = headB;
        while(nodeB != null) {
            nodeB = nodeB.next;
            lenB++;
        }

        int diff = 0;
        if(lenA >= lenB) {
            diff = lenA - lenB;
            for(int i = 0; i < diff; i ++) {
                headA = headA.next;
            }
        } else {
            diff = lenB - lenA;
            for(int i = 0; i < diff; i ++) {
                headB = headB.next;
            }
        }

        while(headA != null && headB != null) {
            if(headA == headB) {
                res = headA;
                break;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }

        return res;
    }

    /**
     * Runtime: 3 ms, faster than 24.12% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 39.6 MB, less than 14.28% of Java online submissions for Intersection of Two Linked Lists.
     * 思路：
     *    依次遍历两个链表, 然后将两个链表的节点压入两个栈中。
     *    从栈顶取出两个节点进行比较
     *       如果两个栈都只有一个节点、且两个节点相等,那直接返回这个节点;
     *       如果两个栈最后一个节点相等,则继续比较,知道找到第一个不相等的节点,那么这个不相等的节点的上一个节点,就是链表相交的第一个节点.
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode res = null;

        Stack<ListNode> nodeStackA = new Stack<ListNode>();
        Stack<ListNode> nodeStackB = new Stack<ListNode>();
        while(headA != null) {
            nodeStackA.push(headA);
            headA = headA.next;
        }
        while(headB != null) {
            nodeStackB.push(headB);
            headB = headB.next;
        }

        ListNode topA = nodeStackA.pop();
        ListNode topB = nodeStackB.pop();
        ListNode preA = null;
        ListNode preB = null;
        while(topA == topB) {
            preA = topA;
            preB = topB;
            if(nodeStackA.isEmpty() && nodeStackB.isEmpty()) {
                break;
            }
            if(!nodeStackA.isEmpty()) {
                topA = nodeStackA.pop();
            }
            if(!nodeStackB.isEmpty()) {
                topB = nodeStackB.pop();
            }


        }

        return preA;
    }

    /**
     * Runtime: 7 ms, faster than 22.40% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 39.6 MB, less than 13.57% of Java online submissions for Intersection of Two Linked Lists.
     * 思路：
     *    (1)遍历链表A,将每个节点放入SetA中
     *    (2)遍历链表B,判断当前节点是否在SetA中。如果在,返回这个节点即可。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode res = null;

        Set<ListNode> hashcodeSet = new HashSet<ListNode>();
        while(headA != null) {
            hashcodeSet.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(hashcodeSet.contains(headB)) {
                res = headB;
                break;
            }
            headB = headB.next;
        }

        return res;
    }

    /**
     * 改变了链表结构
     * 思路：
     *    先翻转两个链表,然后遍历其中一个翻转后的链表,如果当前两个节点的next不相等时,返回当前节点即可。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode res = null;

        headA = reversal(headA);
        headB = reversal(headB);
        if(headA == headB) {
            res = headA;
        }
        while(headA != null && headB != null) {
            if(headA.next == headB.next) {
                headA = headA.next;
                headB = headB.next;
            } else {
                res = headA;
                break;
            }
        }

        return res;
    }

    public ListNode reversal(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }

        return cur;
    }

}
