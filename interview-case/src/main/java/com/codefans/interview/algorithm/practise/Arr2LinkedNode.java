package com.codefans.interview.algorithm.practise;


import com.codefans.reusablecode.datastructure.ListNode;

import static com.codefans.reusablecode.datastructure.ListNodeUtils.print;

/**
 * @author: codefans
 * @date: 2019-03-30 23:35:27
 */
public class Arr2LinkedNode {

    public static void main(String[] args) {
        Arr2LinkedNode arr2LinkedNode = new Arr2LinkedNode();
        arr2LinkedNode.generate();
    }

    public void generate() {
        int[] arr = new int[]{1,2,1};
        ListNode linkedNode = this.generate(arr);
        print(linkedNode);
    }

    public ListNode generate(int[] arr) {
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



}
