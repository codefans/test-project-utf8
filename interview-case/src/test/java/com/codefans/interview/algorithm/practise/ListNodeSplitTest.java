/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ListNodeSplitTest
 * Author:   caishengzhi
 * Date:     2021/5/26 14:07
 * Description: 链表拆分测试类
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import com.codefans.interview.algorithm.common.ListNodeUtils;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 链表拆分测试类
 *
 * @author: codefans
 * @Date: 2021/05/26 14:07
 * @since: 1.0.0
 */
public class ListNodeSplitTest {

    /**
     *
     */
    private ListNodeSplit listNodeSplit;

    @Before
    public void before() {
        listNodeSplit = new ListNodeSplit();
    }

    @Test
    public void spiltOddTest() {

        ListNode head = ListNodeFactory.createByArr(1,2,3,4,5,6,7);
        System.out.println("原链表：");
        ListNodeUtils.print(head);

        ListNode oddNodeList = listNodeSplit.spiltOdd(head);

        System.out.println("奇数节点组成的链表：");
        ListNodeUtils.print(oddNodeList);

    }

    @Test
    public void spiltEvenTest() {

        ListNode head = ListNodeFactory.createByArr(1,2,3,4,5,6,7);
        System.out.println("原链表：");
        ListNodeUtils.print(head);

        ListNode evenNodeList = listNodeSplit.spiltEven(head);

        System.out.println("偶数节点组成的链表：");
        ListNodeUtils.print(evenNodeList);

    }


}