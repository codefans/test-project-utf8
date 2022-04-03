/**
 * Copyright (C), 2015-2021, 京东
 * FileName: StartWithEndWith
 * Author:   codefans
 * Date:     2021/4/9 17:52
 * Description: 以什么开始以什么结束正则匹配
 */
package com.codefans.reusablecode.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 以什么开始以什么结束正则匹配
 *
 * @author: codefans
 * @Date: 2021/04/09 17:52
 * @since: 1.0.0
 */
public class StartWithEndWith {

    public static void main(String[] args) {
        String regex = "";
        String sourceLine = "[INFO] Building smc-app-mobile 2.0-SNAPSHOT";
        StartWithEndWith startWithEndWith = new StartWithEndWith();
        System.out.println("解析结果：");

        /**
         * 匹配不上, 里面的中括号[和空格等属于特殊字符, 需要用\\进行转义
         */
        regex = "^(?=[INFO] Building ).*(?<= 2.0-SNAPSHOT)$";
        System.out.println(startWithEndWith.parseLine(regex, sourceLine, 0));

        /**
         * 输出[INFO] Building smc-app-mobile 2.0-SNAPSHOT
         * 结果只有一个组
         */
        regex = "^(?=\\[INFO\\]\\ Building).*(?<=\\ 2\\.0\\-SNAPSHOT)$";
        System.out.println(startWithEndWith.parseLine(regex, sourceLine, 0));

        /**
         * 输出[INFO] Building smc-app-mobile 2.0-SNAPSHOT
         * 以“你好”开头：^(?=你好)
         * 以“你好”结尾：(?<=你好)$
         * 结果只有1个组
         */
        regex = "^(?=\\[INFO\\]\\ Building)(.*)(?<=\\ 2\\.0\\-SNAPSHOT)$";
        System.out.println(startWithEndWith.parseLine(regex, sourceLine, 0));

        /**
         * 输出[INFO] Building smc-app-mobile 2.0-SNAPSHOT
         * [a-z\\-]*其中, 中括号内的内容表示字符a到z以及字符横杆-, *号表示任意个
         * 结果只有1个组
         */
        regex = "^(\\[INFO\\]\\ Building\\ )([a-z\\-]*)(\\ 2\\.0\\-SNAPSHOT)$";
        System.out.println(startWithEndWith.parseLine(regex, sourceLine, 0));

        /**
         * 输出[INFO] Building smc-app-mobile 2.0-SNAPSHOT
         * 结果只有1个组
         */
        regex = "^\\[INFO\\]\\ Building\\ ([a-z\\-]*)\\ 2\\.0\\-SNAPSHOT$";
        System.out.println(startWithEndWith.parseLine(regex, sourceLine, 0));

        /**
         * 输出[INFO] Building smc-app-mobile 2.0-SNAPSHOT
         * 结果有4个组
         * group(0)：[INFO] Building smc-app-mobile 2.0-SNAPSHOT
         * group(1)：[INFO] Building
         * group(2)：smc-app-mobile
         * group(3)： 2.0-SNAPSHOT
         */
        regex = "(\\[INFO\\]\\ Building\\ )(.*)(\\ 2\\.0\\-SNAPSHOT)";
        System.out.println(startWithEndWith.parseLine(regex, sourceLine, 3));

        /**
         * 输出[INFO] Building smc-app-mobile 2.0-SNAPSHOT
         * 结果有4个组
         * group(0)：[INFO] Building smc-app-mobile 2.0-SNAPSHOT
         * group(1)：[INFO] Building
         * group(2)：smc-app-mobile
         * group(3)： 2.0-SNAPSHOT
         */
        regex = "(\\[INFO\\]\\ Building\\ )([a-z\\-]*)(\\ 2\\.0\\-SNAPSHOT)";
        System.out.println(startWithEndWith.parseLine(regex, sourceLine, 3));


    }

    public String parseLine(String regex, String line, int groupIndex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        String result = "";
        if(matcher.find()) {
            result = matcher.group(groupIndex);
        }
        return result;
    }

}