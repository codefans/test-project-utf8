package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import com.codefans.interview.algorithm.special.LinkedListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: codefans
 * @Date: 2019-08-07 22:13
 */

public class No203RemoveLinkedListElementsTest {

    private ListNode node;

    @Before
    public void before() {
        node = ListNodeFactory.createFiveNode();
    }

    @Test
    public void remoteNodeTest() {

        ListNodeUtils.print(node);

        No203RemoveLinkedListElements no203RemoveLinkedListElements = new No203RemoveLinkedListElements();
        no203RemoveLinkedListElements.removeElements(node, 3);

        ListNodeUtils.print(node);

    }


}
