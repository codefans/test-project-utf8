package com.codefans.basicjava.java6.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: codefans
 * @date: 2019-08-23 14:28
 */
public class ConcurrentHashMapMain {

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("aaa", "1");

        if(map.containsKey("aaa")) {
            String val = map.get("aaa");
            map.put("aaa", String.valueOf(Integer.parseInt(val) + 1));

        }

        System.out.println(map.size());

    }

}
