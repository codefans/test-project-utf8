package com.codefans.basicjava.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: codefans
 * @date: 2019-08-23 10:43
 */
public class CollectionHelper {

    public static void print(Map<String, String> map) {
        Iterator<String> iter = map.keySet().iterator();
        String key = "";
        while(iter.hasNext()) {
            key = iter.next();
            System.out.println("key:" + key + ", value:" + map.get(key));
        }
    }

    public static void print(ConcurrentLinkedQueue<String> queue) {
        Iterator<String> iter = queue.iterator();
        boolean isFirst = true;
        while(iter.hasNext()) {
            if(isFirst) {
                System.out.print(iter.next());
                isFirst = false;
            } else {
                System.out.print(", " + iter.next());
            }
        }
        System.out.println();
    }

    public static void print(List<String> listData) {
        String item = null;
        for(int i = 0; i < listData.size(); i ++) {
            item = listData.get(i);
            System.out.println("index[" + (i + 1) + "]=" + item);
        }

    }

}
