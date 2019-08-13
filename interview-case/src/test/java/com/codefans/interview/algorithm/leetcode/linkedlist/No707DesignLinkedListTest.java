package com.codefans.interview.algorithm.leetcode.linkedlist;

import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-08-13 23:51
 */

public class No707DesignLinkedListTest {

    private No707DesignLinkedList linkedList;

    @Before
    public void before() {
        linkedList = new No707DesignLinkedList();
    }

    @Test
    public void linkedListUnitTest01() {

//        测试用例1
//        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//        [[],[1],[3],[1,2],[1],[1],[1]]

        linkedList.addAtHead(1);
        print(linkedList);
        linkedList.addAtTail(3);
        print(linkedList);
        linkedList.addAtIndex(1, 2);
        print(linkedList);
        int val = linkedList.get(1);
        System.out.println("val_index_1=" + val);

        linkedList.deleteAtIndex(1);
        print(linkedList);

        val = linkedList.get(1);
        System.out.println("val_index_1=" + val);


    }

    @Test
    public void linkedListUnitTest02() {

//        测试用例1
//        ["MyLinkedList","addAtIndex","get","deleteAtIndex"]
//        [[],[-1,0],[0],[-1]]

        linkedList.addAtIndex(-1, 0);
        print(linkedList);
        int val = linkedList.get(0);
        System.out.println("val_index_0=" + val);

        linkedList.deleteAtIndex(-1);
        print(linkedList);

    }

    @Test
    public void linkedListUnitTest03() {

//        测试用例1
//        ["MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"]
//        [[],[0],[1,2],[0],[1],[0,1],[0],[1]]

        int val = linkedList.get(0);
        System.out.println("val_index_0=" + val);
        print(linkedList);

        linkedList.addAtIndex(1, 2);
        print(linkedList);

        val = linkedList.get(0);
        System.out.println("val_index_0=" + val);

        val = linkedList.get(1);
        System.out.println("val_index_1=" + val);

        linkedList.addAtIndex(0, 1);
        print(linkedList);

        val = linkedList.get(0);
        System.out.println("val_index_0=" + val);

        val = linkedList.get(1);
        System.out.println("val_index_1=" + val);


    }

    public void print(No707DesignLinkedList linkedList) {
        boolean isFirst = true;
        linkedList = linkedList.next;
        while(linkedList != null) {
            if(isFirst) {
                System.out.print(linkedList.val);
                isFirst = false;
            } else {
                System.out.print(", " + linkedList.val);
            }
            linkedList = linkedList.next;
        }
        System.out.println();

    }


}
