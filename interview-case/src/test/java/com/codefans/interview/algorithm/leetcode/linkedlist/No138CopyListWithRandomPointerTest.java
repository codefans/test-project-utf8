package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-09-09 21:34
 */

public class No138CopyListWithRandomPointerTest {

    private ListNode simpleHead;
    private ComplexListNode head;
    private No138CopyListWithRandomPointer no138CopyListWithRandomPointer;

    @Before
    public void before() {

        head = ComplexListNodeFactory.generateTwoNodeList();
        no138CopyListWithRandomPointer = new No138CopyListWithRandomPointer();

    }

    @Test
    public void copySimpleListTest() {

        simpleHead = ListNodeFactory.createOneNode();
        ListNode node = no138CopyListWithRandomPointer.copySimpleLinkedList(simpleHead);
        ListNodeUtils.print(node);

        simpleHead = ListNodeFactory.createTwoNode();
        node = no138CopyListWithRandomPointer.copySimpleLinkedList(simpleHead);
        ListNodeUtils.print(node);

        simpleHead = ListNodeFactory.createThreeNode();
        node = no138CopyListWithRandomPointer.copySimpleLinkedList(simpleHead);
        ListNodeUtils.print(node);

        simpleHead = ListNodeFactory.createFourNode();
        node = no138CopyListWithRandomPointer.copySimpleLinkedList(simpleHead);
        ListNodeUtils.print(node);

        simpleHead = ListNodeFactory.createFiveNode();
        node = no138CopyListWithRandomPointer.copySimpleLinkedList(simpleHead);
        ListNodeUtils.print(node);

        simpleHead = ListNodeFactory.createSixNode();
        node = no138CopyListWithRandomPointer.copySimpleLinkedList(simpleHead);
        ListNodeUtils.print(node);
    }


    @Test
    public void copyMainListTest() {

        ComplexListNode complexNewNode = no138CopyListWithRandomPointer.copyComplexLinkedList(head);
        ListNodeUtils.printComplexListNode(complexNewNode);

    }


}
