package com.codefans.basicjava.concurrent.threadpool;

import java.util.concurrent.Callable;

/**
 * @Author: codefans
 * @Date: 2022-03-23 12:22
 */

public class AbstractRunnable implements Runnable{

    /**
     *
     */
    private Runnable runnable;

    /**
     *
     * @param runnable
     */
    public AbstractRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        SharedDomain sharedDomain = new SharedDomain();
        sharedDomain.setId(1357L);
        sharedDomain.setName("nameInAbstractRunnable");
        SharedDomainThreadLocal.set(sharedDomain);
        try {
            this.runnable.run();
        } finally {
            SharedDomainThreadLocal.remove();
        }
    }

}
