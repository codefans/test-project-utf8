/**
 * Copyright (C), 2015-2021, 京东
 * FileName: GetLinkedListLengthTest
 * Author:   codefans
 * Date:     2021/7/20 18:14
 * Description: 获取链表长度测试
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.interview.algorithm.common.ListNode;
import com.codefans.interview.algorithm.common.ListNodeFactory;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 获取链表长度测试
 *
 * @author: codefans
 * @Date: 2021/07/20 18:14
 * @since: 1.0.0
 */
public class GetLinkedListLengthTest {

    private GetLinkedListLength getLinkedListLength;

    @Before
    public void before() {
        getLinkedListLength = new GetLinkedListLength();
    }

    @Test
    public void getLenTest() {

        int unitTestCount = 10;
        for(int i = 1; i <= unitTestCount; i ++) {
            ListNode head = ListNodeFactory.createListNode(i);
            int len = getLinkedListLength.getLen(head);
            System.out.println("i=" + i + ", len=" + len + ", i==len:" + (i == len));
        }
    }

}