package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.reusablecode.datastructure.ListNode;
import com.codefans.reusablecode.datastructure.ListNodeFactory;
import com.codefans.reusablecode.datastructure.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: codefans
 * @date: 2019-07-14 21:50
 */
public class No876MiddleOfTheLinkedListTest {

    private No876MiddleOfTheLinkedList no876MiddleOfTheLinkedList;
    private List<ListNode> testDataList;

    @Before
    public void before() {
        no876MiddleOfTheLinkedList = new No876MiddleOfTheLinkedList();
        testDataList = new ArrayList<ListNode>();
        testDataList.add(ListNodeFactory.createOneNode());
        testDataList.add(ListNodeFactory.createTwoNode());
        testDataList.add(ListNodeFactory.createThreeNode());
        testDataList.add(ListNodeFactory.createFourNode());
        testDataList.add(ListNodeFactory.createFiveNode());
        testDataList.add(ListNodeFactory.createSixNode());
    }

    @Test
    public void middleNodeTest() {
        for(ListNode node : testDataList) {
            System.out.println("原链表：" + ListNodeUtils.toString(node) + ", 中间链表：" + ListNodeUtils.toString(no876MiddleOfTheLinkedList.middleNode(node)));
        }
    }

    @Test
    public void middleNode2Test() {
        for(ListNode node : testDataList) {
            System.out.println("原链表：" + ListNodeUtils.toString(node) + ", 中间链表：" + ListNodeUtils.toString(no876MiddleOfTheLinkedList.middleNode2(node)));
        }
    }


}
