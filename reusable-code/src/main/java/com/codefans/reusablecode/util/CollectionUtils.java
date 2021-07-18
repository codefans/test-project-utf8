package com.codefans.reusablecode.util;

import java.util.List;

/**
 * @Author: codefans
 * @Date: 2021-07-18 10:04
 */

public class CollectionUtils {

    /**
     * 将str列表转换为int数组
     * @param list
     * @return
     */
    public static int[] strListToIntArr(List<String> list) {
        int[] arr = new int[list.size()];
        int index = 0;
        for(String str : list) {
            arr[index++] = Integer.parseInt(str);
        }
        return arr;
    }
}
