package com.codefans.interview.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 *
 * @author: codefans
 * @Date: 2021/11/04 10:21
 * @since: 1.0.0
 */
public class No146LRUCache {

    class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, ListNode> mapCache = new HashMap<>(8);
    ListNode head;
    ListNode tail;
    private int count;
    private int capacity;

    public No146LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 添加头结点
     * @param node
     */
    private void addToHead(ListNode node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        ListNode node = mapCache.get(key);
        if(node == null) {
            node = new ListNode(key, value);
            mapCache.put(key, node);
            /**
             * 第一次写, 这个if-else没写对, https://leetcode.com/problems/lru-cache/discuss/45922/JAVA-Easy-Version-To-Understand!!!!
             */
//            if(count < capacity) {
//                addToHead(node);
//                count++;
//            } else {
//                mapCache.remove(tail.pre.key);
//                removeNode(tail.pre);
//                addToHead(node);
//            }

            /**
             * 自己的写法
             */
            addToHead(node);
            count++;
            if(count > capacity) {
                mapCache.remove(tail.pre.key);
                removeNode(tail.pre);
                count--;
            }

        } else {
            node.value = value;
            mapCache.put(key, node);
            removeNode(node);
            addToHead(node);
        }
    }

    public int get(int key) {
        ListNode node = mapCache.get(key);
        if(node == null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.value;
    }

}
