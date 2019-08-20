package com.codefans.interview.algorithm.leetcode.strings;

/**
 * @author: codefans
 * @date: 2019-08-17 17:34
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
 * Memory Usage: 34.3 MB, less than 98.70% of Java online submissions for To Lower Case.
 *
 */
public class No709ToLowerCase {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            sb.append(toUpCase(c));
        }
        return sb.toString();
    }

    public char toUpCase(char c) {
        int n = (int) c;
        if(n >= 65 && n <= 90) {
            return (char)(n + 32);
        } else {
            return c;
        }
    }

}
