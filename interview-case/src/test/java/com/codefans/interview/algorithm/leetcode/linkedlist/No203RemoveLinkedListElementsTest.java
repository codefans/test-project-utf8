package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.reusablecode.datastructure.ListNode;
import com.codefans.reusablecode.datastructure.ListNodeFactory;
import com.codefans.reusablecode.datastructure.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

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

        ListNode head = ListNodeFactory.createByArr(7,7,7,7);
        head = no203RemoveLinkedListElements.removeElements2(head, 7);
        ListNodeUtils.print(head);

    }


}
