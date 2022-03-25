package com.codefans.interview.algorithm.practise;

/**
 * @Author: codefans
 * @Date: 2022-03-25 17:18
 */

public class LongestSubString {

    /**
     * 求字符串source的最长连续子串
     * @param source
     * @return
     */
    public String longestSubStr(String source) {
        int len = source.length();
        int[] dp = new int[len];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 1; i < len; i ++) {
            if(source.charAt(i) == source.charAt(i-1) || toLow((int)source.charAt(i)) == toLow((int)source.charAt(i-1))) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            if(dp[i] > max) {
                maxIndex = i;
                max = dp[i];
            }
        }

//        for(int i = 0; i < len; i ++) {
////            System.out.println(dp[i]);
//            if(dp[i] > max) {
//                maxIndex = i;
//            }
//            max = Math.max(max, dp[i]);
//        }

        int lowIndex = maxIndex - max + 1;
        System.out.println("最大连续子串长度：" + max);
        System.out.println("最大连续子串末尾下标：" + maxIndex);
        System.out.println("最大连续子串开始下标：" + lowIndex);
        return source.substring(lowIndex, maxIndex + 1);
    }

    private int toLow(int n) {
        if(n >= 65 && n <= 90) {
            return n + 32;
        }
        return n;
    }
}
