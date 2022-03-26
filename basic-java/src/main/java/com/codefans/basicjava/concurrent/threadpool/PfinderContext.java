package com.codefans.basicjava.concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @Author: codefans
 * @Date: 2022-03-23 12:06
 */

public class PfinderContext {

    private PfinderContext() {
    }

    public static PfinderContext getInstance() {
        return PfinderContext.InstanceHolder.INSTANCE;
    }

    static final class InstanceHolder {
        static PfinderContext INSTANCE = new PfinderContext();
        InstanceHolder() {
        }
    }

    protected Runnable wrapRunnable(String tracingName, Runnable runnable) {
        return new AbstractRunnable(runnable);
    }

    protected <T> Callable<T> wrapRunnable(String tracingName, Callable<T> callable) {
        return new AbstractCallable(callable);
    }

    public static Runnable asyncWrapper(String tracingName, Runnable runnable) {
        PfinderContext instance = getInstance();
        return instance.wrapRunnable(tracingName, runnable);
    }

    public static <T> Callable<T> asyncWrapper(String tracingName, Callable<T> callable) {
        PfinderContext instance = getInstance();
//        return instance.tracing() ? instance.wrapRunnable(tracingName, callable) : callable;
        return instance.wrapRunnable(tracingName, callable);
    }

    public static Runnable asyncWrapper(Runnable runnable) {
        return asyncWrapper((String)null, (Runnable)runnable);
    }

    public static <T> Callable<T> asyncWrapper(Callable<T> callable) {
        return asyncWrapper((String)null, (Callable)callable);
    }

    public static ExecutorService executorServiceWrapper(ExecutorService originExecutorService) {
        return new TracingExecutorService(originExecutorService);
    }

    public static Executor executorWrapper(Executor originExecutor) {
        return new TracingExecutor(originExecutor);
    }

}
