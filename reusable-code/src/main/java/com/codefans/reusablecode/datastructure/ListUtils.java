package com.codefans.reusablecode.datastructure;

import java.util.List;

/**
 * @Author: codefans
 * @Date: 2022-04-02 12:57
 */

public class ListUtils {

    /**
     *
     * @param list
     */
    public static void print(List<String> list) {
        if(list != null) {
            for (int i = 0; i < list.size(); i ++) {
                if(i != 0) {
                    System.out.print(", ");
                }
                System.out.print(list.get(i));
            }
        }
    }

    /**
     *
     * @param list
     */
    public static void println(List<String> list) {
        if(list != null) {
            for (int i = 0; i < list.size(); i ++) {
                System.out.println(list.get(i));
            }
        }
    }
}
