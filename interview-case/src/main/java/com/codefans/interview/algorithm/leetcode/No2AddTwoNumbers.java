package com.codefans.interview.algorithm.leetcode;

import com.codefans.interview.datastructure.LinkedNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ShengzhiCai
 * @Date: 2018-12-08 22:56
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * 以下两种情况的进位没有考虑到
 * (1)
 *      [5]
        [5]
   (2)
        [1]
        [9,9]
 *
 */

public class No2AddTwoNumbers {

    public LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
        LinkedNode resNode = null;
        int upStep = 0;
        if(l1 != null && l2 != null) {
            int tmp = l1.val + l2.val;
            if(tmp >= 10) {
                resNode = new LinkedNode(tmp%10);
                upStep = tmp/10;
            } else {
                resNode = new LinkedNode(tmp);
            }
        }
        LinkedNode nextNode01 = l1.next;
        LinkedNode nextNode02 = l2.next;
        LinkedNode nextNode = resNode;
        LinkedNode next = null;

        while(nextNode01 != null || nextNode02 != null) {

            if(nextNode01 != null && nextNode02 != null) {
                int tmp = nextNode01.val + nextNode02.val + upStep;
                upStep = 0;
                if(tmp >= 10) {
                    next = new LinkedNode(tmp%10);
                    upStep = tmp/10;
                } else {
                    next = new LinkedNode(tmp);
                }
                nextNode01 = nextNode01.next;
                nextNode02 = nextNode02.next;
            } else if(nextNode01 != null && nextNode02 == null) {
                int tmp = nextNode01.val + upStep;
                upStep = 0;
                if(tmp >= 10) {
                    next = new LinkedNode(tmp%10);
                    upStep = tmp/10;
                } else {
                    next = new LinkedNode(tmp);
                }

                nextNode01 = nextNode01.next;
            } else if(nextNode01 == null && nextNode02 != null) {
                int tmp = nextNode02.val + upStep;
                upStep = 0;
                if(tmp >= 10) {
                    next = new LinkedNode(tmp%10);
                    upStep = tmp/10;
                } else {
                    next = new LinkedNode(tmp);
                }
                nextNode02 = nextNode02.next;
            } else {
                break;
            }
            nextNode.next = next;
            nextNode = nextNode.next;
        }
        if(upStep > 0) {
            nextNode.next = new LinkedNode(upStep);
        }
        nextNode = resNode;
        return nextNode;
    }

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

    public static LinkedNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        LinkedNode dummyRoot = new LinkedNode(0);
        LinkedNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new LinkedNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(LinkedNode node) {
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

    public static void main(String[] args) throws IOException {
        No2AddTwoNumbers no2AddTwoNumbers = new No2AddTwoNumbers();
        no2AddTwoNumbers.runCode();
    }

    public void runCode() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            LinkedNode l1 = stringToListNode(line);
            line = in.readLine();
            LinkedNode l2 = stringToListNode(line);

            LinkedNode ret = addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

}
