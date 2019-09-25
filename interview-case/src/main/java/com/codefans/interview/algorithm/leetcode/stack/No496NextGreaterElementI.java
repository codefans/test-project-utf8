package com.codefans.interview.algorithm.leetcode.stack;

import java.util.*;

/**
 * @Author: codefans
 * @Date: 2019-09-14 22:50
 */

public class No496NextGreaterElementI {

    /**
     * Runtime: 3 ms, faster than 80.32% of Java online submissions for Next Greater Element I.
     * Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Next Greater Element I.
     * From Discuss
     *     https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time-complexity-O(n)-with-explanation
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int numOne = 0;
        int numTwo = 0;

        for(int i = 0; i < nums2.length; i ++) {
            numTwo = nums2[i];
            while(!stack.isEmpty() && stack.peek() < numTwo) {
                map.put(stack.pop(), numTwo);
            }
            stack.push(numTwo);
        }


        int index = 0;
        for(int i = 0; i < nums1.length; i ++) {
            numOne = nums1[i];
            res[i] = map.getOrDefault(numOne, -1);
        }
        return res;
    }

    /**
     * Runtime: 3 ms, faster than 80.33% of Java online submissions for Next Greater Element I.
     * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Next Greater Element I.
     *
     * 算法思路
     *    类似nextGreaterElement方法中的实现,改进的地方是:将数组nums2存放到List中,
     * 这样就可以直接获取数组nums1元素在数组nums2中的位置,然后从这个位置往后遍历,而不需要每次都从头遍历nums2.
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int numOne = 0;
        int numTwo = 0;
        boolean found = false;
        List<Integer> list2 = new ArrayList<Integer>(nums2.length);
        for(int n : nums2) {
            list2.add(n);
        }

        int index = 0;
        for(int i = 0; i < nums1.length; i ++) {
            numOne = nums1[i];
            index = list2.indexOf(numOne);
            if(index < nums2.length - 1) {
                for(int j = index + 1; j < nums2.length; j ++) {
                    if(nums2[j] > numOne) {
                        res[i] = nums2[j];
                        break;
                    } else {
                        res[i] = -1;
                    }
                }
            } else {
                res[i] = -1;
            }
        }
        return res;
    }


    /**
     * Runtime: 9 ms, faster than 9.32% of Java online submissions for Next Greater Element I.
     * Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Next Greater Element I.
     * 时间复杂度
     *    O(n^2)
     * 空间复杂度
     *    O(n)
     *
     * 算法思路
     *    遍历数组nums1,将数组nums1中的每个元素,与数组nums2中的元素依次比较,
     * 如果有比nums1元素大的,则将这个大的元素放入新数组;否则将-1放入新数组.
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int numOne = 0;
        int numTwo = 0;
        boolean found = false;
        for(int i = 0; i < nums1.length; i ++) {
            numOne = nums1[i];
            found = false;
            for(int j = 0; j < nums2.length; j ++) {
                numTwo = nums2[j];
                if(numOne == numTwo) {
                    found = true;
                }
                if(found) {
                    if(numTwo > numOne) {
                        res[i] = numTwo;
                        break;
                    } else {
                        res[i] = -1;
                    }
                } else {
                    res[i] = -1;
                }
            }
            found = false;
        }
        return res;
    }


}
