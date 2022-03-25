package com.codefans.interview.algorithm.practise;

import org.junit.Test;

/**
 * @Author: codefans
 * @Date: 2022-03-25 17:23
 */

public class LongestSubStringTest {

    @Test
    public void longestSubStringTest() {

        //System.out.println((int)'a');
        //System.out.println((int)'A');
        //System.out.println((int)'Z');
        LongestSubString lss = new LongestSubString();

        String[] arr = new String[] {
            "fFfdEeEeeljfdTttTTtt",
            "fFfdljffTttTTtt",
            "fFfffdEeeljfd",
            "fFfdEeEeeeeljfdTt",
        };
//        String source = "fFfdEeEeeljfdTttTTtt";
//        String source = "1111111234567";
        for(String s : arr) {
            String longestSubString = lss.longestSubStr(s);
            System.out.println("原字符串: " + s + ", 最长连续子串：" + longestSubString);
        }

    }


}
