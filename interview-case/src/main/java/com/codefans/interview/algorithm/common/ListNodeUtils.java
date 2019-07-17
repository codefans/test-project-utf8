package com.codefans.interview.algorithm.common;

/**
 * @author: codefans
 * @date: 2019-07-14 21:54
 */
public class ListNodeUtils {

    public static void print(ListNode node) {
        if(node != null) {
            System.out.print("[" + node.val);
        }
        while(node.next != null) {
            System.out.print(", " + node.next.val);
            node = node.next;
        }
        System.out.println("]");
    }

    public static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        if(node != null) {
            sb.append("[" + node.val);
        }
        while(node.next != null) {
            sb.append(", " + node.next.val);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
