package com.codefans.interview.algorithm.leetcode.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Author: codefans
 * @Date: 2019-09-14 16:18
 */

public class No1047RemoveAllAdjacentDuplicatesInString {

    /**
     * Runtime: 10 ms, faster than 78.96% of Java online submissions for Remove All Adjacent Duplicates In String.
     * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
     * 算法思路
     *    类似removeDuplicates方法中的实现,只不过用一个top遍历保存栈顶元素,
     * 然后通过StringBuilder增加或删除元素。
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        char top = ' ';
        int lastIndex = 0;
        for(int i = 0; i < S.length(); i ++) {
            c = S.charAt(i);
            if(i == 0 || sb.length() == 0) {
                sb.append(c);
                lastIndex = 0;
            } else {
                top = sb.charAt(lastIndex);
                if(c == top) {
                    sb.deleteCharAt(lastIndex);
                    lastIndex--;
                } else {
                    sb.append(c);
                    lastIndex++;
                }
            }
        }

        return sb.toString();
    }


    /**
     * Runtime: 39 ms, faster than 54.59% of Java online submissions for Remove All Adjacent Duplicates In String.
     * Memory Usage: 38.6 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
     * 算法思路
     *    通过栈来临时存储字符
     *    1.将字符与栈顶的字符比较,如果相等,则移除栈顶元素;如果不相等,则压入栈顶.
     *    2.将字符遍历输出(通过Iterator从栈底往上输出).
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        char c = ' ';
        char top = ' ';
        for(int i = 0; i < arr.length; i ++) {
            c = arr[i];
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                top = stack.peek();
                if(c == top) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        Iterator iter = stack.iterator();
        while(iter.hasNext()) {
            sb.append(iter.next());
        }
        return sb.toString();
    }


}
