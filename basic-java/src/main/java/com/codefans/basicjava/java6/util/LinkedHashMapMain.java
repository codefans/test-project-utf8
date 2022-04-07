package com.codefans.basicjava.java6.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: codefans
 * @Date: 2022-04-07 23:28
 * https://www.cnblogs.com/flydean/p/hashmap-vs-linkedhashmap.html
 *
 * LinkedHashMap可实现根据插入顺序来遍历元素；
 * 使用场景：
 *    1、需要根据插入顺序来遍历元素；
 *    2、LRU缓存
 */

public class LinkedHashMapMain {

    public static void main(String[] args) {
        LinkedHashMapMain lhmm = new LinkedHashMapMain();
        lhmm.compare();
    }

    public void compare() {
//        this.regularMapCopy();
//        this.linkedHashMapCopy();
        this.linkedHashMapOrder();
    }

    public void regularMapCopy() {
        Map<String, String> dataMap = new HashMap<>(4);
        dataMap.put("name", "zhangsan");
        dataMap.put("age", "18");
        dataMap.put("phone", "12345678901");
        dataMap.put("addr", "xxx-xxx");
        System.out.println("map原來的顺序是：");
        this.print(dataMap);

        Map<String, String> mapCopy = new HashMap<>(dataMap);
        System.out.println("普通putAll之后map副本的顺序是：");
        this.print(mapCopy);
    }

    public void linkedHashMapCopy() {
        Map<String, String> dataMap = new HashMap<>(4);
        dataMap.put("name", "zhangsan");
        dataMap.put("age", "18");
        dataMap.put("phone", "12345678901");
        dataMap.put("addr", "xxx-xxx");
        System.out.println("map原來的顺序是：");
        this.print(dataMap);

        Map<String, String> mapCopy = new LinkedHashMap<>(dataMap);
        System.out.println("LinkedHashMap生成的副本顺序是：");
        this.print(mapCopy);
    }

    public void linkedHashMapOrder() {
        Map<String, String> dataMap = new LinkedHashMap<>(4);
        dataMap.put("name", "zhangsan");
        dataMap.put("age", "18");
        dataMap.put("phone", "12345678901");
        dataMap.put("addr", "xxx-xxx");
        System.out.println("LinkedHashMap的顺序是：");
        this.print(dataMap);

    }

    private void print(Map<String, String> map) {
        Iterator<String> iter = map.keySet().iterator();
        String key = "";
        while(iter.hasNext()) {
            key = iter.next();
            System.out.println("key=" + key + ", val=" + map.get(key));
        }
    }

}
