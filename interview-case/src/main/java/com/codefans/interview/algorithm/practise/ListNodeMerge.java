/**
 * Copyright (C), 2015-2021, 京东
 * FileName: ListNodeAlternate
 * Author:   caishengzhi
 * Date:     2021/5/24 9:28
 * Description: 链表交叉
 */
package com.codefans.interview.algorithm.practise;


import com.codefans.reusablecode.datastructure.ListNode;

/**
 *
 * 链表交叉
 *
 * @author: codefans
 * @Date: 2021/05/24 09:28
 * @since: 1.0.0
 */
public class ListNodeMerge {

    /**
     * 合并链表, 交叉合并
     * @param head1
     * @param head2
     * @return
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode resultNode = head1;
        ListNode cur = head1;
        while(head1 != null && head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            if(next1 != null) {
                head2.next = next1;
            }
            head1 = next1;
            head2 = next2;
        }
        return resultNode;
    }

}
