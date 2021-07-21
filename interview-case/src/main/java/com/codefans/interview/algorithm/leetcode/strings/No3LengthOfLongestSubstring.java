package com.codefans.interview.algorithm.leetcode.strings;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author: codefans
 * @Date: 2021-07-21 9:08
 */

public class No3LengthOfLongestSubstring {

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if(s == null || s.length() == 0) {
            return maxLen;
        }
        int strLen = s.length();
        char[] arr = s.toCharArray();
        int low = 0, high = 1;
        int index = 0;
        char c = arr[index++];
        while(high < strLen && index < strLen) {
            if(arr[index++] != c) {
                high++;
            } else {
                c = arr[index];
                if(high - low > maxLen) {
                    maxLen = high - low;
                }
                low = index;
                high = index;
                index++;
            }
        }
        return maxLen;
    }

}
