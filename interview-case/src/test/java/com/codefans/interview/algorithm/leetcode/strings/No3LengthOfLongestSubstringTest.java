package com.codefans.interview.algorithm.leetcode.strings;

import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2021-07-21 9:09
 */

public class No3LengthOfLongestSubstringTest {

    @Test
    public void lenghOfLongestSubstringTest() {

        No3LengthOfLongestSubstring no3LengthOfLongestSubstring = new No3LengthOfLongestSubstring();
//        String s = "abcabcbb";
//        String s = "bbbbb";
        String s = "pwwkew";
        int len = no3LengthOfLongestSubstring.lengthOfLongestSubstring(s);
        System.out.println("len=" + len);

    }
}
