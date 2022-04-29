package com.codefans.basicjava.java6.util;

import com.codefans.basicjava.util.CollectionHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: codefans
 * @date: 2019-08-23 10:30
 */
public class HashMapMain {

    public static void main(String[] args) {

        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("111", "aaa");
        dataMap.put("222", "bbb");
        dataMap.put("333", "ccc");
        dataMap.put("444", "ddd");
        dataMap.put("555", "eee");
        dataMap.put("666", "fff");
        dataMap.put("777", "ggg");
        dataMap.put("888", "hhh");
        dataMap.put("999", "iii");
        dataMap.put("000", "jjj");
        dataMap.put("1111", "kkk");
        dataMap.put("2222", "lll");
        dataMap.put("3333", "mmm");
        dataMap.put("4444", "nnn");
        dataMap.put("5555", "ooo");
        dataMap.put("6666", "ppp");
        dataMap.put("7777", "qqq");
        dataMap.put("7777", "qqq2");
        dataMap.put(null, "qqq");
        dataMap.put(null, "bbb");
        dataMap.put("8888", null);
        dataMap.put(null, null);

        CollectionHelper.print(dataMap);



    }




}
