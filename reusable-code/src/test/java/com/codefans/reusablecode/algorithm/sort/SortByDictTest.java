package com.codefans.reusablecode.algorithm.sort;

import com.codefans.reusablecode.util.PrintUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: codefans
 * @Date: 2022-10-16 21:47
 */

public class SortByDictTest {

    @Test
    public void sortByDictTest() {

//        String[] arr = new String[]{"aac", "aab", "aad"};
//        String[] arr = new String[]{"data", "timestamp", "rsaPublicKey"};
//        String[] arr = new String[]{"uid", "featureList", "rsaPublicKey"};
//        String[] arr = new String[]{"configCodeList", "phnMd5", "rsaPublicKey"};
//        String[] arr = new String[]{"uid", "actionType", "rsaPublicKey"};
//        String[] arr = new String[]{"data", "timestamp", "rsaPublicKey"};
        String[] arr = new String[]{"uid", "activeStartAt", "activeEndAt", "rsaPublicKey"};
        System.out.println("数组排序:");
        PrintUtils.printStrArray(arr);
        Arrays.sort(arr);
        PrintUtils.printStrArray(arr);

        System.out.println("列表排序:");
        List<String> list = Arrays.asList("uid", "activeStartAt", "activeEndAt", "rsaPublicKey");
        PrintUtils.printStrList(list);
        Collections.sort(list);
        PrintUtils.printStrList(list);

        System.out.println("Map排序:");
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("uid", "12445465667565");
        treeMap.put("activeStartAt", "2023-03-23 00:00:00");
        treeMap.put("activeEndAt", "2023-03-23 23:59:59");
        treeMap.put("rsaPublicKey", "dfdfdhgjyykhggffrgefdsdsds");

        PrintUtils.printMapKeySets(treeMap);
    }

}
