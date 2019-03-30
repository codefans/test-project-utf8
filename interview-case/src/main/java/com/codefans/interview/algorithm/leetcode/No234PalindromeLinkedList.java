package com.codefans.interview.algorithm.leetcode;

import com.codefans.interview.datastructure.LinkedNode;

import java.util.ArrayList;
import java.util.List;

import static com.codefans.interview.datastructure.LinkedNodeUtils.generate;
import static com.codefans.interview.datastructure.LinkedNodeUtils.toNodeString;

/**
 * @author: codefans
 * @date: 2019-03-30 22:48:24
 */
public class No234PalindromeLinkedList {

    public static void main(String[] args) {
        No234PalindromeLinkedList no234PalindromeLinkedList = new No234PalindromeLinkedList();
        no234PalindromeLinkedList.isPalindrome();
    }

    /**
     * 1->2
     *    false
     * 1->2->2->1
     *    true
     * 1->2->3->2->1
     *    true
     * -31900,22571,-31634,19735,13748,16612,-28299,-16628,9614,-14444,-14444,9614,-16628,-31900,16612,13748,19735,-31634,22571,-28299
     *    false
     * -1->1
     *    false
     * null
     *    false
     * 1
     *    true
     *
     */
    public void isPalindrome() {

        int num1 = 1;
        int num2 = 11;
        int num3 = 121;
        int num4 = 1221;
        int num5 = 12321;
        int num6 = -1;
        int num7 = 10;
        int num8 = -121;
        int num9 = 1001;
        int num10 = 1232;
        int num11 = 1234554321;

        int[] arr = new int[]{1};
        LinkedNode linkedNode = generate(arr);
        String nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{1,1};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{1,2,1};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{1,2,2,1};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{1,2,3,2,1};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{-1};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{1,0};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();


        arr = new int[]{-1,2,1};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{1,0,0,1};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{1,2,3,2};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();

        arr = new int[]{1,2,3,4,5,5,4,3,2,1};
        linkedNode = generate(arr);
        nodeStr = toNodeString(linkedNode);
        System.out.printf("%s " + (isPalindrome(linkedNode) ? "is" : " is not ") + " palindrome", nodeStr);System.out.println();



    }

    public boolean isPalindrome(LinkedNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        List<Integer> data = new ArrayList<Integer>();
        StringBuffer sb = new StringBuffer();
        int val = -1;
        while(head != null) {
            val = head.val;
            data.add(val);
            sb.append(val);
            head = head.next;
        }
        StringBuffer sbuffer = new StringBuffer();
        for(int i = data.size() - 1; i >= 0 ; i --) {
            val = data.get(i);
            sbuffer.append(val);
        }
        return sb.toString().equals(sbuffer.toString());
    }







}
