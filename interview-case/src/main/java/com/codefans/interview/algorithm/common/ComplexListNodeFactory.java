package com.codefans.interview.algorithm.common;

/**
 * @Author: codefans
 * @Date: 2019-09-09 21:38
 */

public class ComplexListNodeFactory {

    public static ComplexListNode generateTwoNodeList() {
        ComplexListNode firstNode = new ComplexListNode(10);

        ComplexListNode secondNode = new ComplexListNode(20);

        firstNode.next = secondNode;
        firstNode.random = secondNode;

        secondNode.next = null;
        secondNode.random = secondNode;

        return firstNode;
    }

}
