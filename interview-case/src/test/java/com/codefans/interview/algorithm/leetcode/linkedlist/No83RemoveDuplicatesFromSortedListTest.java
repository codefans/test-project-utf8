/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No83RemoveDuplicatesFromSortedListTest
 * Author:   codefans
 * Date:     2021/5/28 11:53
 * Description: 链表重复数据删除
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.reusablecode.datastructure.ListNode;
import com.codefans.reusablecode.datastructure.ListNodeFactory;
import com.codefans.reusablecode.datastructure.ListNodeUtils;
import org.junit.Test;

/**
 *
 * 链表重复数据删除
 *
 * @author: codefans
 * @Date: 2021/05/28 11:53
 * @since: 1.0.0
 */
public class No83RemoveDuplicatesFromSortedListTest {

    @Test
    public void deleteDuplicates2Test() {

        No83RemoveDuplicatesFromSortedList no83RemoveDuplicatesFromSortedList = new No83RemoveDuplicatesFromSortedList();
        ListNode head = ListNodeFactory.createByArr(1,1,1,2,3,3,3,3);
        System.out.println("原链表数据：");
        ListNodeUtils.print(head);
        ListNode result = no83RemoveDuplicatesFromSortedList.deleteDuplicates2(head);
        System.out.println("删除重复数据后：");
        ListNodeUtils.print(result);
    }

}
