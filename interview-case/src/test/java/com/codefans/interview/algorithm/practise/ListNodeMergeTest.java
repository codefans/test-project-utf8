/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ListNodeMergeTest
 * Author:   caishengzhi
 * Date:     2021/5/24 15:56
 * Description: 链表穿插合并
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Test;

/**
 *
 * 链表穿插合并
 *
 * @author: codefans
 * @Date: 2021/05/24 15:56
 * @since: 1.0.0
 */
public class ListNodeMergeTest {

    @Test
    public void listNodeMergeTest() {

        ListNodeMerge listNodeMerge = new ListNodeMerge();
//        ListNode listNode01 = ListNodeFactory.createByArr(null);
//        ListNode listNode02 = ListNodeFactory.createByArr(null);

//        ListNode listNode01 = ListNodeFactory.createByArr(1);
//        ListNode listNode02 = ListNodeFactory.createByArr(2);

//        ListNode listNode01 = ListNodeFactory.createByArr(1,3,5);
//        ListNode listNode02 = ListNodeFactory.createByArr(2,4,6,8,10);

//        ListNode listNode01 = ListNodeFactory.createByArr(1,3,5,7,9);
//        ListNode listNode02 = ListNodeFactory.createByArr(2,4,6);

        ListNode listNode01 = ListNodeFactory.createByArr(1,3,5);
        ListNode listNode02 = ListNodeFactory.createByArr(2,4,6);

        ListNode resultNode = listNodeMerge.merge(listNode01, listNode02);
        ListNodeUtils.print(resultNode);

    }

}