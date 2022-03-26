package com.codefans.basicjava.concurrent.threadpool;

import java.util.concurrent.Callable;

/**
 * @Author: codefans
 * @Date: 2022-03-23 12:21
 */

public class AbstractCallable implements Callable {

    /**
     *
     */
    private Callable callable;

    /**
     *
     * @param callable
     */
    public AbstractCallable(Callable callable) {
        this.callable = callable;
    }

    @Override
    public Object call() throws Exception {
        Object obj = null;
        SharedDomain sharedDomain = new SharedDomain();
        sharedDomain.setId(123456789L);
        sharedDomain.setName("nameInAbstractCallable");
        SharedDomainThreadLocal.set(sharedDomain);
        try {
            obj = this.callable.call();
        } finally {
            SharedDomainThreadLocal.remove();
        }
        return obj;
    }
}
