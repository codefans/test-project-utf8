package com.codefans.interview.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: codefans
 * @Date: 2019-08-21 22:54
 */

public class KthNodeFromEnd {

    public LinkedListNode getKthNodeMethod01(LinkedListNode firstNode, int k) {
        List<LinkedListNode> nodeList = new ArrayList<LinkedListNode>();
        LinkedListNode head = firstNode;
        while(head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int size = nodeList.size();
        if(size == 0 || k <= 0) {
            return null;
        }
        return nodeList.get(size - k);
    }

    public LinkedListNode getKthNodeFromEnd(LinkedListNode head, int k) {
        if(head == null || k <= 0) {
            return null;
        }
        LinkedListNode fastNode = head;
        LinkedListNode slowNode = head;
        for(int i = 1; i <= k - 1; i ++) {
            if(fastNode.next != null) {
                fastNode = fastNode.next;
            } else {
                return null;
            }
        }
        while(fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }










}
