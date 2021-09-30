package com.codefans.interview.algorithm.offer;


import org.junit.Test;

/**
 *
 * 找到第一个只出现一次的字符测试类
 *
 * @author: codefans
 * @Date: 2021/09/30 13:52
 * @since: 1.0.0
 */
public class FindFirstUniqueCharTest {

    @Test
    public void firstUniqueCharTest() {

        System.out.println((int)'a');
        System.out.println((int)'z');

//        String str = "abaccdeff";
//        String str = "leetcode";
//        String str = "";
//        String str = "cc";
//        String str = "aadadaad";
        String[] arr = new String[]{
            "abaccdeff",
            "leetcode",
            "",
            "cc",
            "aadadaad",
        };

        FindFirstUniqueChar findFirstUniqueChar = new FindFirstUniqueChar();
        for(String str : arr) {
//        System.out.println(findFirstUniqueChar.firstUniqChar(str));
            System.out.println(findFirstUniqueChar.firstUniqChar2(str));
        }

    }



}