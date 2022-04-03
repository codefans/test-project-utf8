/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No92ReverseLinkedList2
 * Author:   caishengzhi
 * Date:     2021/5/12 17:33
 * Description: leetcode第92题反转链表2-中等难度
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.reusablecode.datastructure.ListNode;

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
        ListNode firstNode = head;
        ListNode prefixNode = null;
        ListNode suffixNode = head;
        ListNode newHead = null;
        int index = 1;
        while(head != null) {
            if(index < left) {
                prefixNode = head;
                head = head.next;
                suffixNode = head;
            } else
            if(index <= right) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
                if(left == 1) {
                    firstNode = newHead;
                }
            } else {
                break;
            }
            index++;
        }
//        System.out.println("head.val=" + head.val + ", newHead.val=" + newHead.val);
        if(prefixNode != null) {
//            System.out.println("prefixNode != null, prefixNode.val=" + prefixNode.val);
            prefixNode.next = newHead;
        }
        if(suffixNode != null) {
//            System.out.println("suffixNode != null, suffixNode.val=" + suffixNode.val);
            suffixNode.next = head;
        }
        return firstNode;
    }

    /**
     * 1->2->3->4->5
     * 1   ---------5
     * |  |
     * |  2<-3<-4
     * |        |
     * ---------
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetweenMiddle(ListNode head, int left, int right) {
        ListNode firstNode = head;
        ListNode prefixNode = null;
        ListNode suffixNode = null;
        ListNode newHead = null;
        int index = 1;
        while(head != null) {
            if(index < left) {
                prefixNode = head;
                head = head.next;
                suffixNode = head;
            } else
            if(index <= right) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            } else {
                break;
            }
            index++;
        }
        System.out.println("head.val=" + head.val + ", newHead.val=" + newHead.val);
        if(prefixNode != null) {
            System.out.println("prefixNode != null, prefixNode.val=" + prefixNode.val);
            prefixNode.next = newHead;
        }
        if(suffixNode != null) {
            System.out.println("suffixNode != null, suffixNode.val=" + suffixNode.val);
            suffixNode.next = head;
        }
        return firstNode;
    }

    /**
     * 1->2->3->4->5
     * 1<-2<-3
     * |
     * ------->4->5
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetweenLeftPrefix(ListNode head, int left, int right) {
        ListNode firstNode = head;
        ListNode prefixNode = null;
        ListNode suffixNode = head;
        ListNode newHead = null;
        int index = 1;
        while(head != null) {
            if(index < left) {
                prefixNode = head;
                head = head.next;
            } else
            if(index <= right) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
                if(left == 1) {
                    firstNode = newHead;
                }
            } else {
                break;
            }
            index++;
        }
        System.out.println("head.val=" + head.val + ", newHead.val=" + newHead.val);
        if(prefixNode != null) {
            System.out.println("prefixNode != null, prefixNode.val=" + prefixNode.val);
            prefixNode.next = newHead;
        }
        if(suffixNode != null) {
            System.out.println("suffixNode != null, suffixNode.val=" + suffixNode.val);
            suffixNode.next = head;
        }
        return firstNode;
    }

    /**
     * 1->2->3->4->5->6
     * 1->2->3
     *          4<-5<-6
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetweenRightSuffix(ListNode head, int left, int right) {
        ListNode firstNode = head;
        ListNode prefixNode = null;
        ListNode suffixNode = null;
        ListNode newHead = null;
        int index = 1;
        while(head != null) {
            if(index < left) {
                prefixNode = head;
                head = head.next;
                System.out.println("index=" + index + ", left=" + left + ", prefixNode.val=" + prefixNode.val + ", head.val=" + head.val);
            } else
            if(index <= right) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            } else {
                break;
            }
            index++;
        }
        System.out.println("head.val=" + (head == null ? "head is null" : head.val) + ", newHead.val=" + (newHead == null ? "newHead is null" : newHead.val));
        if(prefixNode != null) {
            System.out.println("prefixNode != null, prefixNode.val=" + prefixNode.val);
            prefixNode.next = newHead;
        }
        if(suffixNode != null) {
            System.out.println("suffixNode != null, suffixNode.val=" + suffixNode.val);
            suffixNode.next = head;
        }
        return firstNode;
    }

}
