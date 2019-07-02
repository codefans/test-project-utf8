package com.codefans.opensource.rocketmq;

import java.util.Iterator;
import java.util.Set;

/**
 * @author: codefans
 * @date: 2019-07-02 17:49
 */
public class RocketmqBase {

    public static final String NAMESRV_ADDR = "10.75.229.81:9876;10.75.229.83:9876";

    public void printSet(Set<String> sets) {
        Iterator<String> iter = sets.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
