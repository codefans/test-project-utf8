package com.codefans.interview.datastructure;

/**
 * @author: codefans
 * @date: 2019-03-31 00:12:07
 */
public class LinkedNodeUtils {

    public static LinkedNode generate(int[] arr) {
        LinkedNode head = null;
        LinkedNode current = null;
        LinkedNode next = null;
        if(arr != null && arr.length > 0) {
            for(int i = 0; i < arr.length; i ++) {
                if(i == 0) {
                    head = new LinkedNode(arr[0]);
                    next = head;
                } else {
                    current = new LinkedNode(arr[i]);
                    next.next = current;
                    next = current;
                }
            }
        }
        return head;
    }

    public static String toNodeString(LinkedNode node) {
        boolean isFirst = true;
        StringBuffer sb = new StringBuffer();
        while(node != null) {
            if(isFirst) {
                sb.append(node.val);
                isFirst = false;
            } else {
                sb.append("," + node.val);
            }
            node = node.next;
        }
        return sb.toString();
    }

    public static void print(LinkedNode node) {
        boolean isFirst = true;
        while(node != null) {
            if(isFirst) {
                System.out.print(node.val);
                isFirst = false;
            } else {
                System.out.print("," + node.val);
            }
            node = node.next;
        }
    }

}
