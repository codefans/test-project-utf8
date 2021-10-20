package com.codefans.reusablecode.util;


import java.util.List;

/**
 * 字符串处理类
 *
 * @author: codefans
 * @Date: 2021/10/20 10:09
 * @since: 1.0.0
 */
public class StringUtils {

    /**
     * 将数组转为字符串
     * @param arr
     * @return
     */
    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length*2);
        for(int i = 0; i < arr.length; i ++) {
            if(i != 0) {
                sb.append(",");
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * 将列表转为字符串
     * @param list
     * @return
     */
    public static String toString(List<Integer> list) {
        StringBuilder sb = new StringBuilder(list.size()*2);
        for(int i = 0; i < list.size(); i ++) {
            if(i != 0) {
                sb.append(",");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

}