package com.codefans.interview.algorithm.leetcode.linkedlist;

import com.codefans.reusablecode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: codefans
 * @Date: 2019-07-27 23:06
 */

public class No21MergeTwoSortedLists {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 39.1 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists0(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists0(l1, l2.next);
            return l2;
        }
    }

    /**
     * 思路:
     *    定义一个头节点为0的链表head,一个指向头节点的指针curr,
     *    然后比较链表l1和链表l2当前节点的大小,然后将curr.next指向较小的节点.
     *    最后返回head.next即可.
     *
     * 我们只要管head链表是不是最终我们想要的,而不要考虑它与链表l1和l2是否有交叉
     * Runtime:0ms, faster than 100.00%
     * Memory Usage:39.7MB, less than 14.90%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) {
            curr.next = l1;
        }
        if(l2 != null) {
            curr.next = l2;
        }
        return result.next;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Merge Two Sorted Lists.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsMethod4(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode cur = null;
        if(l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        cur = head;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if(l1 != null) {
            cur.next = l1;
        }
        if(l2 != null) {
            cur.next = l2;
        }

        return head;
    }


    /**
     * 用一个新链表,比较两个链表,小的值加到新链表后面
     * Runtime:1ms, faster than 27.83%
     * Memory Usage:39.8MB, less than 14.44%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsMethod3(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode current = null;
        if(l1.val <= l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        current = head;

        ListNode pre = null;
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    current.next = new ListNode(l1.val);
                    current = current.next;
                    l1 = l1.next;
                } else {
                    current.next = new ListNode(l2.val);
                    current = current.next;
                    l2 = l2.next;
                }
            } else if(l1 == null) {
                current.next = l2;
                break;
            } else if(l2 == null) {
                current.next = l1;
                break;
            }
        }


        return head;

    }

    /**
     * 思路
     *    将l1插入到l2
     * Runtime:0ms, faster than 100.00%
     * Memory Usage:39.3MB, less than 16.29%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsMethod2(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode head = l2;
        ListNode pre = null;

        while(l1 != null) {
            if(l1.val <= l2.val) {
                ListNode node = new ListNode(l1.val);
                if(pre == null) {
                    node.next = l2;
                    pre = node;
                    head = pre;
                } else {

                    pre.next = node;
                    node.next = l2;
                    pre = node;
                }
                l1 = l1.next;

            } else {
                if(l1.val > l2.val) {
                    if(l2.next == null) {
                        l2.next = l1;
                        break;
                    } else {
                        pre = l2;
                        l2 = l2.next;

                    }
                }
            }
        }

        return head;
    }


    /**
     * Runtime:2ms, faster than 27.83%
     * Memory Usage:40MB, less than 13.70%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsMethod1(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        List<Integer> arr = new ArrayList<Integer>();
        while(l1 != null) {
            arr.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            arr.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(arr);
        ListNode head = null;
        ListNode next = null;
        for(int i = 0; i < arr.size(); i ++) {
            if(i == 0) {
                head = new ListNode(arr.get(i));
                next = head;
            } else {
                next.next = new ListNode(arr.get(i));
                next = next.next;
            }
        }

        return head;

    }

}
