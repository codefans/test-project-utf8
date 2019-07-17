package com.codefans.opensource.redis;

/**
 * @author: codefans
 * @date: 2019-07-12 14:11
 */
public class RedisContext {

    private static ThreadLocal<String> currentAddr = new ThreadLocal();

    public static void setAddr(String addr) {
        currentAddr.set(addr);
    }

    public static String getAddr() {
        return currentAddr.get();
    }


}
