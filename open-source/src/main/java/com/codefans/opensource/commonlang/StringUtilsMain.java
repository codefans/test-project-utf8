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
        sum.joinTest();
    }

    public void joinTest() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        System.out.println(StringUtils.join(list, ","));
    }


}