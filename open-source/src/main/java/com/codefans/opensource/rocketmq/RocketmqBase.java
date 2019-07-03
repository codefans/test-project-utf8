package com.codefans.opensource.rocketmq;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: codefans
 * @date: 2019-07-02 17:49
 */
public class RocketmqBase {

    public static final String NAMESRV_ADDR = "10.75.229.81:9876;10.75.229.83:9876";
    public static final String DEFAULT_SUBEXPRESSION = "*";

    public void printSet(Set<String> sets) {
        if(sets == null) {
            throw new NullPointerException("sets is null");
        }
        Iterator<String> iter = sets.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public void printMap(Map<String, Set<String>> dataMap) {

        if(dataMap == null) {
            throw new NullPointerException("sets is null");
        }
        Iterator<String> iter = dataMap.keySet().iterator();
        String key = "";
        Set<String> data = null;

        while(iter.hasNext()) {
            key = iter.next();
            data = dataMap.get(key);
            System.out.println("key=" + key + ", value=" + data.toString());
        }
    }

}
