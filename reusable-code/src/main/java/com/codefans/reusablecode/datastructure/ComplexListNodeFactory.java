package com.codefans.reusablecode.datastructure;

/**
 * @Author: codefans
 * @Date: 2019-09-09 21:38
 */

public class ComplexListNodeFactory {

    /**
     * 构造两个节点的复杂链表
     * @return
     */
    public static ComplexListNode generateTwoNodeList() {
        ComplexListNode firstNode = new ComplexListNode(10);
        ComplexListNode secondNode = new ComplexListNode(20);

        firstNode.next = secondNode;
        firstNode.random = secondNode;
        secondNode.random = null;

        return firstNode;
    }

    /**
     * 构造3个节点的复杂链表
     * @return
     */
    public static ComplexListNode generateThreeNodeList() {
        ComplexListNode firstNode = new ComplexListNode(10);
        ComplexListNode secondNode = new ComplexListNode(20);
        ComplexListNode thirdNode = new ComplexListNode(30);

        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        firstNode.random = secondNode;
        secondNode.random = null;
        thirdNode.random = firstNode;

        return firstNode;
    }

    /**
     * 构造3个节点的复杂链表
     * @return
     */
    public static ComplexListNode generateThreeNodeList2() {
        ComplexListNode firstNode = new ComplexListNode(40);
        ComplexListNode secondNode = new ComplexListNode(50);
        ComplexListNode thirdNode = new ComplexListNode(60);

        firstNode.next = secondNode;
        secondNode.next = thirdNode;

        firstNode.random = secondNode;
        secondNode.random = null;
        thirdNode.random = firstNode;

        return firstNode;
    }


}
