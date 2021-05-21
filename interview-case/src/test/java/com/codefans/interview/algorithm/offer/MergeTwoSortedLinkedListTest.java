/**
 * Copyright (C), 2015-2021, 京东
 * FileName: MergeTwoSortedLinkedListTest
 * Author:   caishengzhi
 * Date:     2021/5/21 11:05
 * Description: 合并两个有序链表测试类
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Test;

/**
 *
 * 合并两个有序链表测试类
 *
 * @author: codefans
 * @Date: 2021/05/21 11:05
 * @since: 1.0.0
 */
public class MergeTwoSortedLinkedListTest {

    @Test
    public void mergeTwoSortedLinkedListTest() {

        MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();
//        ListNode l1 = ListNodeFactory.createByArr(1);
//        ListNode l2 = ListNodeFactory.createByArr(2);
//        ListNode l1 = ListNodeFactory.createByArr(1,3,5);
//        ListNode l2 = ListNodeFactory.createByArr(2,4,6);
//        ListNode l1 = ListNodeFactory.createByArr(1,3,5,7,9);
//        ListNode l2 = ListNodeFactory.createByArr(2,4,6);
        ListNode l1 = ListNodeFactory.createByArr(1,2,3);
        ListNode l2 = ListNodeFactory.createByArr(1,2,3);
        ListNode resListNode = mergeTwoSortedLinkedList.mergeTwoLists2(l1, l2);
        ListNodeUtils.print(l1);
        ListNodeUtils.print(l2);
        ListNodeUtils.print(resListNode);

    }

}