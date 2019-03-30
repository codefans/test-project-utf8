package com.codefans.interview.algorithm.practise;

import com.codefans.interview.datastructure.LinkedNode;
import static com.codefans.interview.datastructure.LinkedNodeUtils.print;

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
        LinkedNode linkedNode = this.generate(arr);
        print(linkedNode);
    }

    public LinkedNode generate(int[] arr) {
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



}
