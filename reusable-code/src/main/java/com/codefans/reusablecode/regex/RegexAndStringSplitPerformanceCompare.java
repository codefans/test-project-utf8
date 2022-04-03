/**
 * Copyright (C), 2015-2021, 京东
 * FileName: RegexAndStringSplitPerformanceCompare
 * Author:   codefans
 * Date:     2021/4/9 18:17
 * Description: 正则和字符串切割性能比较
 */
package com.codefans.reusablecode.regex;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 正则和字符串切割性能比较
 *
 * @author: codefans
 * @Date: 2021/04/09 18:17
 * @since: 1.0.0
 */
public class RegexAndStringSplitPerformanceCompare {

    public static void main(String[] args) {
        RegexAndStringSplitPerformanceCompare compare = new RegexAndStringSplitPerformanceCompare();
//        compare.regexPerformance();
//        compare.stringSplitPerformance();
        compare.stringSplitPerformance2();
    }

    /**
     * 正则性能测试
     */
    public void regexPerformance() {
        int loopCount = 1000000;
        long begin = System.currentTimeMillis();
        String regex = "(\\[INFO\\]\\ Building\\ )([a-z\\-]*)(\\ 2\\.0\\-SNAPSHOT)";
        Pattern pattern = Pattern.compile(regex);
        for(int i = 0; i < loopCount; i ++) {
            String res = parseLine(pattern, "[INFO] Building smc-app-mobile 2.0-SNAPSHOT", 2);
//            System.out.println("regexPerformance=" + res);
        }
        long end = System.currentTimeMillis();
        /**
         * 363、333、363、352、307
         */
        System.out.println("regexPerformance() cost:[" + (end - begin) + "ms]");
    }

    /**
     * 解析正则表达式
     * @param pattern
     * @param line
     * @param groupIndex
     * @return
     */
    public String parseLine(Pattern pattern, String line, int groupIndex) {
        Matcher matcher = pattern.matcher(line);
        String result = "";
        if(matcher.find()) {
            result = matcher.group(groupIndex);
        }
        return result;
    }

    /**
     * 字符串切割性能测试
     */
    public void stringSplitPerformance() {
        int loopCount = 1000000;
        long begin = System.currentTimeMillis();
        String sourceStr = "[INFO] Building smc-app-mobile 2.0-SNAPSHOT";
        String prefix = "[INFO] Building ";
        String suffix = " 2.0-SNAPSHOT";
        for(int i = 0; i < loopCount; i ++) {
            String res = sourceStr.substring(sourceStr.indexOf(prefix) + prefix.length(), sourceStr.indexOf(suffix));
//            System.out.println("stringSplitPerformance=" + res);
        }
        long end = System.currentTimeMillis();
        /**
         * 62、66、63、65、60
         * 这里用的都是同一个sourceStr, 因为缓存的原因, 所以非常快
         */
        System.out.println("stringSplitPerformance() cost:[" + (end - begin) + "ms]");
    }

    /**
     * 字符串切割性能测试2
     */
    public void stringSplitPerformance2() {
        int loopCount = 1000000;
        long begin = System.currentTimeMillis();
        String sourceStr;
        String prefix = "[INFO] Building ";
        String suffix = " 2.0-SNAPSHOT";
        char[] chars = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','-'};
        Random random = new Random();
        for(int i = 0; i < loopCount; i ++) {
            /**
             * 构造不同的sourceStr
             */
            sourceStr = prefix + chars[random.nextInt(chars.length)] + suffix;
            String res = sourceStr.substring(sourceStr.indexOf(prefix) + prefix.length(), sourceStr.indexOf(suffix));
//            System.out.println("stringSplitPerformance=" + res);
        }
        long end = System.currentTimeMillis();
        /**
         * 141、135、147、135、140
         */
        System.out.println("stringSplitPerformance() cost:[" + (end - begin) + "ms]");
    }

}