package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.interview.algorithm.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: codefans
 * @Date: 2019-07-31 1:17
 */

public class No141LinkedListCycle {

    /**
     * 思路：
     *    遍历链表，然后将节点对象放入Set中，然后判断下一个节点是否在Set集合中，如果在，则存在环。
     *    （注意：不能通过判断值是否在某个集合中来判断是否是同一个节点）
     *
     * Runtime: 5 ms, faster than 9.27% of Java online submissions for Linked List Cycle.
     * Memory Usage: 38.2 MB, less than 80.09% of Java online submissions for Linked List Cycle.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        if(head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<ListNode>();
        boolean isCycle = false;
        while(head != null) {
            if(head.next != null && set.contains(head.next)) {
                isCycle = true;
                break;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return isCycle;
    }
}
