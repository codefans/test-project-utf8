package com.codefans.basicjava.util;

/**
 * @author: codefans
 * @date: 2019-07-08 10:34
 */
public class CommonUtils {

    public static void print(String[] arr) {
        for(String str : arr) {
            System.out.println(str);
        }
    }

    public static void printInLine(int[] arr) {
        for(int i = 0; i < arr.length; i ++) {
            if(i != 0) {
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

}
