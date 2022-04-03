/**
 * Copyright (C), 2015-2021, 京东
 * FileName: FindFirstCommonNode
 * Author:   caishengzhi
 * Date:     2021/5/21 15:12
 * Description: 查询链表第一个公共节点
 */
package com.codefans.interview.algorithm.offer;


import com.codefans.reusablecode.datastructure.ListNode;
import com.codefans.reusablecode.datastructure.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *
 * 查询链表第一个公共节点
 *
 * @author: codefans
 * @Date: 2021/05/21 15:12
 * @since: 1.0.0
 */
public class FindFirstCommonNode {

    /**
     * 查询链表第一个公共节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode findCommonNode(ListNode l1, ListNode l2) {
        ListNode commonNode = null;
        Set<ListNode> nodeSet = new HashSet<>();
        while(l1 != null) {
            nodeSet.add(l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            if(nodeSet.contains(l2)) {
                commonNode = l2;
                break;
            }
            l2 = l2.next;
        }
        return commonNode;
    }

    /**
     * 查询链表第一个公共节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode findCommonNode2(ListNode l1, ListNode l2) {
        ListNode commonNode = null;
        int len01 = ListNodeUtils.getLen(l1);
        int len02 = ListNodeUtils.getLen(l2);
        int step;
        if(len01 > len02) {
            step = len01 - len02;
            for(int i = 0; i < step; i ++) {
                l1 = l1.next;
            }
        } else {
            step = len02 - len01;
            for(int i = 0; i < step; i ++) {
                l2 = l2.next;
            }
        }
        while(l1 != null && l2 != null) {
            if(l1 == l2) {
                commonNode = l1;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return commonNode;
    }

    /**
     * 查询链表第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode findCommonNode3(ListNode headA, ListNode headB) {
        ListNode commonNode = null;
        Stack<ListNode> stackA = new Stack<>();
        while(headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        Stack<ListNode> stackB = new Stack<>();
        while(headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode topA, topB;
        while(!stackA.isEmpty() && !stackB.isEmpty()) {
            topA = stackA.pop();
            topB = stackB.pop();
            if(topA == topB) {
                commonNode = topA;
            }
        }
        return commonNode;
    }


}
