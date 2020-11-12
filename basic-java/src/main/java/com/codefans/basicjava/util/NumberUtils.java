/**
 * Copyright (C), 2015-2020, 京东
 * FileName: NumberUtils
 * Author:   codefans
 * Date:     2020/9/3 21:59
 * Description: 数字处理
 */
package com.codefans.basicjava.util;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * 数字处理
 *
 * @author codefans
 * @date 2020/09/03 21:59
 * @since 1.0.0
 */
public class NumberUtils {

    /**
     * 保留scale位小数, 不四舍五入
     * @param number
     * @return
     */
    public static String format(String number, int scale) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(scale, RoundingMode.DOWN);
        return bd.toString();
    }

    /**
     * 保留2位小数, 不四舍五入
     * @param number
     * @return
     */
    public static String formatTwoDecimals(String number) {
        return format(number, 2);
    }

    public static void main(String[] args) {

        System.out.println(formatTwoDecimals("1"));
        System.out.println(formatTwoDecimals("-11"));
        System.out.println(formatTwoDecimals("1.0"));
        System.out.println(formatTwoDecimals("1.1234677"));
        System.out.println(formatTwoDecimals("1.18989"));
        System.out.println(formatTwoDecimals("0.18989"));
    }

}