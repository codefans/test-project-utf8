package com.codefans.basicjava.concurrent.threadpool;

import java.util.concurrent.Executor;

/**
 * @Author: codefans
 * @Date: 2022-03-23 11:09
 */

public class TracingExecutor implements Executor {

    private final Executor origin;

    public TracingExecutor(Executor origin) {
        this.origin = origin;
    }

    public void execute(Runnable command) {
        this.origin.execute(PfinderContext.asyncWrapper(command));
    }
}
