package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2019-07-28 1:50
 */

public class No21MergeTwoSortedListsTest {

    @Test
    public void test() {

        No21MergeTwoSortedLists mergeTwoSortedLists = new No21MergeTwoSortedLists();

        ListNode l1 = ListNodeFactory.createThreeNode();
        ListNode l2 = ListNodeFactory.createThreeNode();
        ListNode result = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        ListNodeUtils.print(l1);
        ListNodeUtils.print(l2);
        ListNodeUtils.print(result);

    }

}
