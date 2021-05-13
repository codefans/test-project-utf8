package com.codefans.interview.algorithm.common;

/**
 * @author: codefans
 * @date: 2019-07-14 21:54
 */
public class ListNodeUtils {

    public static void print(ListNode node) {
        if(node == null) {
            System.out.println("node is null");
            return;
        }
        if(node != null) {
            System.out.print("[" + node.val);
        }
        while(node.next != null) {
            System.out.print(", " + node.next.val);
            node = node.next;
        }
        System.out.println("]");
    }

    public static void printComplexListNode(ComplexListNode node) {
        int index = 1;
        if(node != null) {
            System.out.print("[" + (index + "_" + node.val + "_" + node.next.val + "_" + node.random.val));
        }
        index++;
        node = node.next;
        while(node != null) {
            System.out.print(", " + (index + "_" + node.val + "_" + (node.next == null ? null : node.next.val) + "_" + (node.random == null ? null : node.random.val)));
            node = node.next;
            index++;
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
