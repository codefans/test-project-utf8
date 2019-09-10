package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ComplexListNode;
import com.codefans.interview.algorithm.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: codefans
 * @Date: 2019-09-04 23:05
 *
 * 思路：
 *    (1)先拷贝主链表
 *    (2)再拷贝随机指针
 *        a.用index+"_"+value去定位一个节点
 *        b.老链表：将老链表的node为key，将index+"_"+value作为value存到一个map中
 *        c.新链表：将index+"_"+value为key，将新链表的node作为value存到另一个map中
 *        d.遍历老链表，循环体中遍历新链表，根据老链表的node.random，获取index+"_"+value，然后根据index+"_"+value获取新链表中的节点，然后将当前节点的random指向这个节点。完成指针的拷贝。
 */

public class No138CopyListWithRandomPointer {

    /**
     * Runtime: 2 ms, faster than 74.06% of Java online submissions for Copy List with Random Pointer.
     * Memory Usage: 33.6 MB, less than 99.07% of Java online submissions for Copy List with Random Pointer.
     *
     * @param head
     * @return
     */
    public ComplexListNode copyComplexLinkedList(ComplexListNode head) {

        ComplexListNode node = null;
        int index = 1;
        int val = 0;
        Map<ComplexListNode, String> headNodeMap = new HashMap<ComplexListNode, String>();
        Map<String, ComplexListNode> nodeMap = new HashMap<String, ComplexListNode>();

        ComplexListNode curNode = head;
        if(curNode != null) {
            val = curNode.val;
            node = new ComplexListNode(val);
            nodeMap.put(index+"_" + val, node);

            headNodeMap.put(curNode, index+"_" + val);

            curNode = curNode.next;
            index++;
        }

        ComplexListNode first = node;

        ComplexListNode newNode = null;

        while(curNode != null) {
            val = curNode.val;
            newNode = new ComplexListNode(val);
            nodeMap.put(index+"_" + val, newNode);

            headNodeMap.put(curNode, index+"_" + val);

            node.next = newNode;
            node = node.next;

            curNode = curNode.next;
            index++;
        }

        String identify = "";
        ComplexListNode cur = first;
        curNode = head;
        while(curNode != null) {

            if(curNode.random != null) {
                identify = headNodeMap.get(curNode.random);
                if(identify != "" && identify != null) {
                    cur.random = nodeMap.get(identify);
                }
            } else {
                cur.random = null;
            }
            cur = cur.next;
            curNode = curNode.next;
        }
        return first;
    }

    public ListNode copySimpleLinkedList(ListNode head) {
        ListNode node = null;
        if(head != null) {
            node = new ListNode(head.val);
            head = head.next;
        }
        ListNode cur = node;
        ListNode newNode = null;
        while(head != null) {
            newNode = new ListNode(head.val);
            cur.next = newNode;
            cur = cur.next;
            head = head.next;
        }

        return node;
    }
}
