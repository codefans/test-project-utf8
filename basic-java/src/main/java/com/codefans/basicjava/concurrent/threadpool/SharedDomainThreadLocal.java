package com.codefans.basicjava.concurrent.threadpool;

/**
 * @Author: codefans
 * @Date: 2022-03-24 15:37
 */

public class SharedDomainThreadLocal {

    /**
     *
     */
    private static final ThreadLocal<SharedDomain> threadLocal = new ThreadLocal<>();

    /**
     *
     * @param sharedDomain
     */
    public static void set(SharedDomain sharedDomain) {
        threadLocal.set(sharedDomain);
    }

    /**
     *
     * @return
     */
    public static SharedDomain get() {
        return threadLocal.get();
    }

    /**
     *
     */
    public static void remove() {
        threadLocal.remove();
    }
}
