package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-07-25 1:27
 */

public class No237DeleteNodeInALinkedListTest {

    private ListNode node;

    @Before
    public void before() {
        node = ListNodeFactory.createFiveNode();
    }
    @Test
    public void deleteNodeTest() {

        ListNode thirdNode = node.next.next;
        int deleteNodeVal = thirdNode.val;
        System.out.println("原列表为:");
        ListNodeUtils.print(node);
        No237DeleteNodeInALinkedList deleteNodeInALinkedList = new No237DeleteNodeInALinkedList();
        deleteNodeInALinkedList.deleteNode(thirdNode);
        System.out.println("列表删除节点:[" + deleteNodeVal + "]后为:");
        ListNodeUtils.print(node);

    }


}
