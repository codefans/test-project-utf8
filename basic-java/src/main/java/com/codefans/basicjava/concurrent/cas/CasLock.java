package com.codefans.basicjava.concurrent.cas;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: codefans
 * @date: 2019-07-04 14:05
 */
public class CasLock {

    private volatile AtomicBoolean lock = new AtomicBoolean(true);

    public void lock() {
        boolean flag;
        do {
            flag = this.lock.compareAndSet(true, false);
        }
        while (!flag);
    }

    public void unlock() {
        this.lock.compareAndSet(false, true);
    }


}
