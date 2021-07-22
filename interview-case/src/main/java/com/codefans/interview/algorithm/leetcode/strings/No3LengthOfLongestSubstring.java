package com.codefans.interview.algorithm.leetcode.strings;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author: codefans
 * @Date: 2021-07-21 9:08
 */

public class No3LengthOfLongestSubstring {

    /**
     * 滑动窗口
     * 耗时: 19ms毫秒
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if(s == null || s.length() == 0) {
            return maxLen;
        }
        if(s.length() == 1) {
            return 1;
        }
        int strLen = s.length();
        HashSet<Character> hashSet = new HashSet<Character>();
        int right = -1;
        for(int i = 0; i < strLen; i ++) {
            if(i != 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            while(right + 1 < strLen && !hashSet.contains(s.charAt(right + 1))) {
                hashSet.add(s.charAt(right + 1));
                right++;
            }
            maxLen = Math.max(maxLen, right - i + 1);
        }
        return maxLen;
    }

    /**
     * 暴力破解
     * longestSubstringLen=95, cost=[3569164]ms毫秒, [3569.164]s秒, [59.49]m分钟
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int maxLen = 0;
        if(s == null || s.length() == 0) {
            return maxLen;
        }
        if(s.length() == 1) {
            return 1;
        }
        int strLen = s.length();
        String subStr = "";
        for(int i = 0; i < strLen - 1; i ++) {
            for(int j = i + 1; j <= strLen; j ++) {
                subStr = s.substring(i, j);
                boolean hasRepeatChar = !hasRepeatChar(subStr);
                //System.out.println("subStr=[" + subStr + "], hasRepeatChar=" + hasRepeatChar);
                if(hasRepeatChar) {
                    int subLen = subStr.length();
                    maxLen = Math.max(maxLen, subLen);
                }
            }
        }
        return maxLen;
    }

    private boolean hasRepeatChar(String subStr) {
        boolean hasRepeat = false;
        char[] arr = subStr.toCharArray();
        HashSet<Character> hashSet = new HashSet<Character>();
        char c;
        for(int i = 0; i < arr.length; i ++) {
            c = arr[i];
            if(hashSet.contains(c)) {
                hasRepeat = true;
                break;
            } else {
                hashSet.add(c);
            }
        }
        return hasRepeat;
    }

}
