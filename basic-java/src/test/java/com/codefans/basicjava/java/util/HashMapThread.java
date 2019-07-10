package com.codefans.basicjava.java.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: codefans
 * @date: 2017-10-17 15:10
 *
 * 执行命令：
 * jps
 * jstack pid
 *
 * 参考资料：
 * 图解集合 5 ：不正确地使用HashMap引发死循环及元素丢失
 * http://www.importnew.com/25070.html
 *
 *
 **/
public class HashMapThread extends Thread {

    private static AtomicInteger ai = new AtomicInteger(0);
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(1);

    public void run()
    {
        while (ai.get() < 100000)
        {
            map.put(ai.get(), ai.get());
            ai.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        HashMapThread hmt0 = new HashMapThread();
        HashMapThread hmt1 = new HashMapThread();
        HashMapThread hmt2 = new HashMapThread();
        HashMapThread hmt3 = new HashMapThread();
        HashMapThread hmt4 = new HashMapThread();
        hmt0.start();
        hmt1.start();
        hmt2.start();
        hmt3.start();
        hmt4.start();
    }


}
