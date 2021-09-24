/**
 * Copyright (C), 2015-2021, 京东
 * FileName: PrintUtils
 * Author:   caishengzhi
 * Date:     2021/9/24 18:37
 * Description: 输出工具类
 */
package com.codefans.reusablecode.util;


import java.util.List;

/**
 *
 * 输出工具类
 *
 * @author: codefans
 * @Date: 2021/09/24 18:37
 * @since: 1.0.0
 */
public class PrintUtils {

    /**
     * 打印list
     * @param list
     */
    public static final void printStrList(List<String> list) {
        if(list != null && list.size() > 0) {
            for(int i = 0; i < list.size(); i ++) {
                if(i != 0) {
                    System.out.print(", ");
                }
                System.out.print(list.get(i));
            }
        } else {
            System.out.println("list为空！！！");
        }
    }

    /**
     * 打印list
     * @param list
     */
    public static final void printIntList(List<Integer> list) {
        if(list != null && list.size() > 0) {
            for(int i = 0; i < list.size(); i ++) {
                if(i != 0) {
                    System.out.print(", ");
                }
                System.out.print(list.get(i));
            }
        } else {
            System.out.println("list为空！！！");
        }
    }

}