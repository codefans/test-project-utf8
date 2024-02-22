/**
 * Copyright (C), 2015-2021, 京东
 * FileName: StringUtilsMain
 * Author:   codefans
 * Date:     2021/8/25 18:11
 * Description: StringUtils测试
 */
package com.codefans.opensource.commonlang;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * StringUtils测试
 *
 * @author: codefans
 * @Date: 2021/08/25 18:11
 * @since: 1.0.0
 */
public class StringUtilsMain {

    public static void main(String[] args) {
        StringUtilsMain sum = new StringUtilsMain();
        sum.allTest();
    }

    public void allTest() {
        this.joinTest();
        this.capitalizeTest();
        this.uncapitalizeTest();
    }

    public void joinTest() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        System.out.println(StringUtils.join(list, ","));
    }


    public void capitalizeTest() {
        System.out.println(StringUtils.capitalize(null)); //输出：null
        System.out.println(StringUtils.capitalize("")); //输出：""
        System.out.println(StringUtils.capitalize("cat")); //输出："Cat"
        System.out.println(StringUtils.capitalize("cAt")); //输出："CAt"
        System.out.println(StringUtils.capitalize("'cat'")); //输出："'cat'"
    }

    public void uncapitalizeTest() {
        System.out.println(StringUtils.uncapitalize(null)); //输出：null
        System.out.println(StringUtils.uncapitalize("")); //输出：""
        System.out.println(StringUtils.uncapitalize("cat")); //输出："cat"
        System.out.println(StringUtils.uncapitalize("Cat")); //输出："cat"
        System.out.println(StringUtils.uncapitalize("CAT")); //输出："cAT"
    }

}