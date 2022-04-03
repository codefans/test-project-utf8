/**
 * Copyright (C), 2015-2021, 京东
 * FileName: GetLinkedListLength
 * Author:   caishengzhi
 * Date:     2021/7/20 18:11
 * Description: 获取链表长度
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.reusablecode.datastructure.ListNode;

/**
 *
 * 获取链表长度
 *
 * @author: codefans
 * @Date: 2021/07/20 18:11
 * @since: 1.0.0
 */
public class GetLinkedListLength {

    /**
     * 获取链表长度
     * @param head
     * @return
     */
    public int getLen(ListNode head) {
        int len = 0;
        while(head != null && head.next != null) {
            len += 2;
            head = head.next.next;
        }
        if(head != null) {
            len += 1;
        }
        return len;
    }

}
