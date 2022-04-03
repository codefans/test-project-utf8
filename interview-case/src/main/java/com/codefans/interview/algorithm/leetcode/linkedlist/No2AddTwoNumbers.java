/**
 * Copyright (C), 2015-2021, 京东
 * FileName: No2AddTwoNumbers
 * Author:   caishengzhi
 * Date:     2021/5/19 14:34
 * Description: 两数相加
 */
package com.codefans.interview.algorithm.leetcode.linkedlist;


import com.codefans.reusablecode.datastructure.ListNode;
import com.codefans.reusablecode.datastructure.ListNodeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 两数相加
 * https://leetcode.com/problems/add-two-numbers/
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 2018-12-08 22:56第一遍做的时候, 以下两种情况的进位没有考虑到
 *    (1)
 *         [5]
 *         [5]
 *    (2)
 *         [1]
 *         [9,9]
 *
 * @author: codefans
 * @Date: 2021/05/19 14:34
 * @since: 1.0.0
 */
public class No2AddTwoNumbers {

    /**
     *   2->4->3
     *  +5->6->4
     *  --------
     *   7->0->8
     *
     *   写的时候出现的问题：
     *      两个链表可能长短不一样, 短的为null后, 需要将值重置为0;
     *      相加不大于10时, 需要将进位add重置为0;
     *      最后如果add大于0, 则需要增加一个节点。
     *
     *   待优化点：
     *      只用现成的两个链表，不新建链表
     *
     * @Date 2021-05-20 09:58
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resListNode = null;
        ListNode current = null;

        int val01 = 0;
        int val02 = 0;
        int sum = 0;
        int add = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                val01 = l1.val;
            }
            if(l2 != null) {
                val02 = l2.val;
            }
            sum = val01 + val02 + add;
            val01 = 0;
            val02 = 0;
            if(sum >= 10) {
                add = sum / 10;
            } else {
                add = 0;
            }
            ListNode newListNode = new ListNode(sum % 10);
            if(resListNode == null) {
                resListNode = newListNode;
                current = resListNode;
            } else {
                current.next = newListNode;
                current = current.next;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(add > 0) {
            current.next = new ListNode(add);
        }
        return resListNode;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode resNode = null;
        int upStep = 0;
        if(l1 != null && l2 != null) {
            int tmp = l1.val + l2.val;
            if(tmp >= 10) {
                resNode = new ListNode(tmp%10);
                upStep = tmp/10;
            } else {
                resNode = new ListNode(tmp);
            }
        }
        ListNode nextNode01 = l1.next;
        ListNode nextNode02 = l2.next;
        ListNode nextNode = resNode;
        ListNode next = null;

        while(nextNode01 != null || nextNode02 != null) {

            if(nextNode01 != null && nextNode02 != null) {
                int tmp = nextNode01.val + nextNode02.val + upStep;
                upStep = 0;
                if(tmp >= 10) {
                    next = new ListNode(tmp%10);
                    upStep = tmp/10;
                } else {
                    next = new ListNode(tmp);
                }
                nextNode01 = nextNode01.next;
                nextNode02 = nextNode02.next;
            } else if(nextNode01 != null && nextNode02 == null) {
                int tmp = nextNode01.val + upStep;
                upStep = 0;
                if(tmp >= 10) {
                    next = new ListNode(tmp%10);
                    upStep = tmp/10;
                } else {
                    next = new ListNode(tmp);
                }

                nextNode01 = nextNode01.next;
            } else if(nextNode01 == null && nextNode02 != null) {
                int tmp = nextNode02.val + upStep;
                upStep = 0;
                if(tmp >= 10) {
                    next = new ListNode(tmp%10);
                    upStep = tmp/10;
                } else {
                    next = new ListNode(tmp);
                }
                nextNode02 = nextNode02.next;
            } else {
                break;
            }
            nextNode.next = next;
            nextNode = nextNode.next;
        }
        if(upStep > 0) {
            nextNode.next = new ListNode(upStep);
        }
        nextNode = resNode;
        return nextNode;
    }

    public static void main(String[] args) throws IOException {
        No2AddTwoNumbers no2AddTwoNumbers = new No2AddTwoNumbers();
        no2AddTwoNumbers.runCode();
    }

    public void runCode() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = ListNodeUtils.stringToListNode(line);
            line = in.readLine();
            ListNode l2 = ListNodeUtils.stringToListNode(line);

            ListNode ret = addTwoNumbers(l1, l2);

            String out = ListNodeUtils.listNodeToString(ret);

            System.out.print(out);
        }
    }

}
