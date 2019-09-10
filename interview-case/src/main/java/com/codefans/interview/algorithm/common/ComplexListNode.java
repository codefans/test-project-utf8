package com.codefans.interview.algorithm.common;

/**
 * @Author: codefans
 * @Date: 2019-09-04 22:10
 */

public class ComplexListNode {

    public int val;

    public ComplexListNode next;

    public ComplexListNode random;

    public ComplexListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ComplexListNode getNext() {
        return next;
    }

    public void setNext(ComplexListNode next) {
        this.next = next;
    }

    public ComplexListNode getRandom() {
        return random;
    }

    public void setRandom(ComplexListNode random) {
        this.random = random;
    }
}
