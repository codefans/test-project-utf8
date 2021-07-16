package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-09-12 23:01
 */

public class No160IntersectionOfTwoLinkedListsTest {

    private ListNode headA;
    private ListNode headB;
    private No160IntersectionOfTwoLinkedLists no160IntersectionList;

    @Before
    public void beforeMethod() {
        /**
         * 1->2
         *      4->5
         *    3
         */
        headA = new ListNode(1);
        ListNode nodeC = new ListNode(2);
        headB = new ListNode(3);
        ListNode nodeD = new ListNode(4);
        ListNode nodeE = new ListNode(5);

        headA.next = nodeC;
        nodeC.next = nodeD;
        headB.next = nodeD;
        nodeD.next = nodeE;

        no160IntersectionList = new No160IntersectionOfTwoLinkedLists();
    }

    @Test
    public void getIntersectionNodeTest() {
        ListNode interectionNode = no160IntersectionList.getIntersectionNode(headA, headB);
        System.out.println("getIntersectionNode=" + interectionNode.val);
    }

    @Test
    public void getIntersectionNode2Test() {
        ListNode interectionNode = no160IntersectionList.getIntersectionNode2(headA, headB);
        System.out.println("getIntersectionNode2=" + interectionNode.val);
    }

    @Test
    public void getIntersectionNode3Test() {
        ListNode interectionNode = no160IntersectionList.getIntersectionNode3(headA, headB);
        System.out.println("getIntersectionNode3=" + interectionNode.val);
    }

    @Test
    public void getIntersectionNode4Test() {
        ListNode interectionNode = no160IntersectionList.getIntersectionNode4(headA, headB);
        System.out.println("getIntersectionNode4=" + interectionNode.val);
    }

}
