package com.codefans.interview.algorithm;

import com.codefans.interview.algorithm.offer.KthNodeFromEnd;
import com.codefans.interview.algorithm.offer.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: codefans
 * @Date: 2019-08-14 21:57
 */

public class LinkedListTest {

    LinkedListNode firstNode;
    KthNodeFromEnd kthNodeFromEnd;

    @Before
    public void initLinkedList() {
        firstNode = new LinkedListNode(1);
        LinkedListNode secondNode = new LinkedListNode(2);
        firstNode.next = secondNode;
        LinkedListNode thirdNode = new LinkedListNode(3);
        secondNode.next = thirdNode;

        thirdNode.next = new LinkedListNode(4);
        thirdNode.next.next = new LinkedListNode(5);
        thirdNode.next.next.next = new LinkedListNode(6);
        thirdNode.next.next.next.next = new LinkedListNode(7);

        kthNodeFromEnd = new KthNodeFromEnd();

    }


    @Test
    public void reverseLinkedListTest() {


        LinkedListNode pre = firstNode;
        LinkedListNode cur = pre.next;
        pre.next = null;
        LinkedListNode next = cur.next;
        while(next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;

        }
        cur.next = pre;

        while(cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }


    }

    @Test
    public void indexKfromLastTest() {

        int kIndex = 2;
        LinkedListNode head = firstNode;
        for(int i = 0; i < 7; i ++) {
            kIndex = i + 1;
            System.out.println("倒数第[" + kIndex + "]个, getKthNodeMethod01值为:" + kthNodeFromEnd.getKthNodeMethod01(head, kIndex).value);
            System.out.println("倒数第[" + kIndex + "]个, getKthNodeFromEnd值为:" + kthNodeFromEnd.getKthNodeFromEnd(head, kIndex).value);
        }

        kIndex = 0;
        LinkedListNode node = kthNodeFromEnd.getKthNodeMethod01(head, kIndex);
        System.out.println("倒数第[" + kIndex + "]个, getKthNodeMethod01值为:" + ((node == null) ? null : node.value));
        head = null;
        kIndex = 3;
        node = kthNodeFromEnd.getKthNodeFromEnd(head, kIndex);
        System.out.println("head is null, 倒数第[" + kIndex + "]个, getKthNodeFromEnd值为:" + (node == null ? null : node.value));

    }


}
