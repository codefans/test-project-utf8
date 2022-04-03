package com.codefans.interview.algorithm.offer;


import java.util.*;

/**
 *
 * 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * @author: codefans
 * @Date: 2021/09/30 13:50
 * @since: 1.0.0
 */
public class FindFirstUniqueChar {

    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     *示例 1:
     * 输入：s = "abaccdeff"
     * 输出：'b'
     *
     *示例 2:
     * 输入：s = ""
     * 输出：' '
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        char result = ' ';
        int[] exists = new int[26];
        int n = 0;
        for(int i = 0; i < s.length(); i ++) {
            n = s.charAt(i) - 97;
            exists[n]++;
        }
        for(int i = 0; i < s.length(); i ++) {
            if(exists[s.charAt(i) - 97] == 1) {
                result = s.charAt(i);
                break;
            }
        }
        return result;
    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        char result = ' ';
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char tmp = ' ';
        for(int i = 0; i < len; i ++) {
            tmp = s.charAt(i);
            if(!map.containsKey(tmp)) {
                map.put(tmp, 1);
            } else {
                map.put(tmp, map.get(tmp) + 1);
            }
        }
        for(int i = 0; i < len; i ++) {
            tmp = s.charAt(i);
            if(map.get(tmp) == 1) {
                result = tmp;
                break;
            }
        }
        return result;
    }

}
