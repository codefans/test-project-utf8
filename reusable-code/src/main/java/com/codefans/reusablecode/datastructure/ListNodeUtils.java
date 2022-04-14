package com.codefans.reusablecode.datastructure;


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
            System.out.print("[" + (index + "_" + node.val + "_" + (node.next == null ? null : node.next.val) + "_" + (node.random == null ? null : node.random.val)));
            index++;
            node = node.next;
            while(node != null) {
                System.out.print(", " + (index + "_" + node.val + "_" + (node.next == null ? null : node.next.val) + "_" + (node.random == null ? null : node.random.val)));
                node = node.next;
                index++;
            }
            System.out.println("]");
        }
    }

    /**
     * 将链表打印成字符串，格式如下：
     * [1, 2, 3]
     * @param node
     * @return
     */
    public static String toString(ListNode node) {
        if(node == null) {
            return "";
        }
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

    /**
     * 将链表打印成字符串，格式如下：
     * [1, 2, 3]
     * @param node
     * @return
     */
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    /**
     * 将以逗号分隔的字符串转为整型数组
     * @param input
     * @return
     */
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    /**
     * 将字符串转为链表, 字符串格式如下：
     * 1,2,3
     * @param input
     * @return
     */
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    /**
     * 获取链表长度
     * @param listNode
     * @return
     */
    public static int getLen(ListNode listNode) {
        int len = 0;
        while(listNode != null) {
            len++;
            listNode = listNode.next;
        }
        return len;
    }

    public static ListNode generate(int[] arr) {
        ListNode head = null;
        ListNode current = null;
        ListNode next = null;
        if(arr != null && arr.length > 0) {
            for(int i = 0; i < arr.length; i ++) {
                if(i == 0) {
                    head = new ListNode(arr[0]);
                    next = head;
                } else {
                    current = new ListNode(arr[i]);
                    next.next = current;
                    next = current;
                }
            }
        }
        return head;
    }

    public static String toNodeString(ListNode node) {
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



}
