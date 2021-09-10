package com.codefans.basicjava.util;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @Author: codefans
 * @Date: 2020-11-20 08:05
 */

public class TreeMapTest {

    @Test
    public void consistentHashTest() {

    }

    /**
     * 遍历treeMap
     */
    @Test
    public void treeMapIteratorTest() {

        TreeMap<Long, String> data = new TreeMap<Long, String>();
        data.put(100L, "hello");
        data.put(103L, "world");
        data.put(106L, "zhangsan");
        data.put(116L, "lisi");
        data.put(105L, "wangwu");
        data.put(109L, "lisi");

        Iterator<Long> iter = data.keySet().iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }


    }

    @Test
    public void getNotExistsKeyTest() {
        TreeMap<Long, String> data = new TreeMap<Long, String>();
        data.put(100L, "hello");
        data.put(103L, "world");
        data.put(106L, "zhangsan");
        data.put(116L, "lisi");
        data.put(105L, "wangwu");
        data.put(109L, "lisi");

        /**
         * print hello
         */
        System.out.println(data.get(100L));
        /**
         * print null
         */
        System.out.println(data.get(102L));

    }

    /**
     * tailMap-顺时针
     */
    @Test
    public void tailMapTest() {

        TreeMap<Long, String> data = new TreeMap<Long, String>();
        data.put(100L, "hello");
        data.put(103L, "world");

        /**
         * print 100
         */
        System.out.println(data.tailMap(100L).firstKey());
        /**
         * print 103
         */
        System.out.println(data.tailMap(102L).firstKey());

    }

    /**
     * headMap-逆时针
     */
    @Test
    public void headMapTest() {
        TreeMap<Long, String> data = new TreeMap<Long, String>();
        data.put(100L, "hello");
        data.put(103L, "world");

        /**
         * print 100
         */
        System.out.println(data.headMap(102L).firstKey());

        /**
         * print 100
         * inclusive-表示是否包含当前key
         */
        System.out.println(data.headMap(100L, true).firstKey());

        /**
         * java.util.NoSuchElementException
         * 默认不包含当前key
         */
        System.out.println(data.headMap(100L).firstKey());

    }












}
