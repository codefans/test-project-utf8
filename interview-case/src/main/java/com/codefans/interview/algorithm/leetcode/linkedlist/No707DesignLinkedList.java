package com.codefans.interview.algorithm.leetcode.linkedlist;

/**
 * @Author: codefans
 * @Date: 2019-08-07 23:03
 *
 * Runtime: 54 ms, faster than 57.22% of Java online submissions for Design Linked List.
 * Memory Usage: 45.1 MB, less than 88.89% of Java online submissions for Design Linked List.
 *
 * 出错的测试用例
 * (1) index是负数的话,插入到下标为0的位置,这个忽略了
 * ["MyLinkedList","addAtIndex","get","deleteAtIndex"]
 * [[],[-1,0],[0],[-1]]
 *
 * ["MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"]
 * [[],[0],[1,2],[0],[1],[0,1],[0],[1]]
 *
 *
 */

public class No707DesignLinkedList {

    public int val;
    public No707DesignLinkedList next;

    private int nodeCount;

    /** Initialize your data structure here. */
    public No707DesignLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= nodeCount) {
            return -1;
        }
        if(index == 0) {
            if(next == null) {
                return -1;
            } else {
                return next.val;
            }
        } else {
            No707DesignLinkedList node = next;
            for(int i = 1; i <= index; i ++) {
                node = node.next;
            }
            return node.val;
        }

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        No707DesignLinkedList newNode = new No707DesignLinkedList();
        newNode.val = val;

        if(next == null) {
            next = newNode;
        } else {
            newNode.next = next;
            next = newNode;
        }
        nodeCount++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        No707DesignLinkedList newNode = new No707DesignLinkedList();
        newNode.val = val;

        if(next == null) {
            next = newNode;
        } else {
            No707DesignLinkedList nextNode = next;
            while(nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = newNode;
        }
        nodeCount++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index > nodeCount) {
            return;
        }

        No707DesignLinkedList newNode = new No707DesignLinkedList();
        newNode.val = val;

        if(index <= 0) {
            newNode.next = next;
            next = newNode;
        } else if(index == nodeCount) {
            No707DesignLinkedList nextNode = next;
            while(nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = newNode;
        } else {
            No707DesignLinkedList node = next;
            No707DesignLinkedList pre = null;
            No707DesignLinkedList cur = null;

            for(int i = 1; i <= index; i ++) {
                pre = node;
                cur = pre.next;
                node = node.next;
            }
            pre.next = newNode;
            newNode.next = cur;
        }

        nodeCount++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= nodeCount) {
            return;
        }
        if(index == 0) {
            next = next.next;
        } else {

            No707DesignLinkedList node = next;
            No707DesignLinkedList pre = null;
            No707DesignLinkedList cur = null;

            for(int i = 1; i <= index; i ++) {
                pre = node;
                cur = pre.next;
                node = node.next;
            }
            pre.next = cur.next;

        }
        nodeCount--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
