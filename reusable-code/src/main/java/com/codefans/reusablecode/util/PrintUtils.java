/**
 * Copyright (C), 2015-2021, 京东
 * FileName: PrintUtils
 * Author:   caishengzhi
 * Date:     2021/9/24 18:37
 * Description: 输出工具类
 */
package com.codefans.reusablecode.util;


import java.util.Arrays;
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
     * 打印arr
     * @param arr
     */
    public static final void printStrArray(String[] arr) {
        printStrList(Arrays.asList(arr));
    }

    /**
     * 打印arr
     * @param arr
     */
    public static final void printIntArray(int[] arr) {
        if(arr != null && arr.length > 0) {
            for(int i = 0; i < arr.length; i ++) {
                if(i != 0) {
                    System.out.print(", ");
                }
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            System.out.println("arr为空！！！");
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

    /**
     * 打印list
     * @param list
     */
    public static final void printIntListList(List<List<Integer>> list) {
        if(list != null && list.size() > 0) {
            for(List<Integer> data : list) {
                printIntList(data);
                System.out.println();
            }
        } else {
            System.out.println("list为空！！！");
        }
    }

}