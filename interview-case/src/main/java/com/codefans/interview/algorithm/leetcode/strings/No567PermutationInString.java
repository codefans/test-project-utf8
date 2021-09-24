package com.codefans.interview.algorithm.leetcode.strings;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 567. 字符串的排列
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * @author: codefans
 * @Date: 2021/07/22 11:13
 * @since: 1.0.0
 */
public class No567PermutationInString {

    /**
     * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
     *
     *
     * 示例 1：
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        boolean inclusion = false;
        List<String> list = getSubPermutationStrList(s1);
        for(String str : list) {
            if(s2.contains(str)) {
                inclusion = true;
                break;
            }
        }
        return inclusion;
    }

    public List<String> getSubPermutationStrList(String str) {
        List<String> list = new ArrayList<>();

        return list;
    }

}