package com.codefans.interview.algorithm.leetcode;

/**
 * @author: codefans
 * @date: 2019-07-13 22:54
 */
public class No1119RemoveVowelsFromAString {

    public static void main(String[] args) {
        No1119RemoveVowelsFromAString no1119RemoveVowelsFromAString = new No1119RemoveVowelsFromAString();
        System.out.println('c' != 'a');
        System.out.println("abc".charAt(1));
        String s = "leetcodeisacommunityforcoders";
        System.out.println(no1119RemoveVowelsFromAString.removeVowels(s));
    }

    public String removeVowels(String S) {
        int index = 0;
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        for(int i = 0; i < len; i ++) {
            c = S.charAt(i);
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
