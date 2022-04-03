package com.codefans.interview.algorithm.offer;

import com.codefans.reusablecode.datastructure.ListNode;

/**
 * @Author: codefans
 * @Date: 2019-08-20 21:28
 * O(1)时间复杂度删除链表节点
 */

public class No13CostO1DeleteListNode {

    /**
     * 默认toBeDel是链表中已有的元素,如果toBeDel不是链表中的元素，则会有问题
     *
     * 除了尾结点是O(n)，其他都是O(1)，那么平均时间复杂度(O(1) * (n - 1) + O(n))/n = O(1)
     *
     * @param head
     * @param toBeDel
     */
    public ListNode delete(ListNode head, ListNode toBeDel) {
        if(head == null && toBeDel == null) {
            return null;
        }

        //头节点
        if(head == toBeDel) {
            head = head.next;
        } else //非头结点
        if(toBeDel.next != null) {

            ListNode cur = toBeDel;
            ListNode next = toBeDel.next;
            if(next.next != null) {
                ListNode nextNext = next.next;
                cur.val = next.val;
                cur.next = nextNext;
            } else {
                cur.val = next.val;
                cur.next = null;
            }

        } else { //尾结点
            ListNode node = head;
            while(node != null) {
                if(node.next == toBeDel) {
                    break;
                }
                node = node.next;
            }
            if(node != null) {
                node.next = null;
            }
        }
        return head;
    }

}
