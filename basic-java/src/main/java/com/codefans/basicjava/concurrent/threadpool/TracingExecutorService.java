package com.codefans.basicjava.concurrent.threadpool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: codefans
 * @Date: 2022-03-23 12:04
 */

public class TracingExecutorService implements ExecutorService {

    private final ExecutorService origin;

    public TracingExecutorService(ExecutorService origin) {
        this.origin = origin;
    }

    public void shutdown() {
        this.origin.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.origin.shutdownNow();
    }

    public boolean isShutdown() {
        return this.origin.isShutdown();
    }

    public boolean isTerminated() {
        return this.origin.isTerminated();
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.origin.awaitTermination(timeout, unit);
    }

    public <T> Future<T> submit(Callable<T> task) {
        return this.origin.submit(PfinderContext.asyncWrapper(task));
    }

    public <T> Future<T> submit(Runnable task, T result) {
        return this.origin.submit(PfinderContext.asyncWrapper(task), result);
    }

    public Future<?> submit(Runnable task) {
        return this.origin.submit(PfinderContext.asyncWrapper(task));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        Collection<Callable<T>> wrappedTasks = new ArrayList();
        Iterator var3 = tasks.iterator();

        while(var3.hasNext()) {
            Callable<T> task = (Callable)var3.next();
            wrappedTasks.add(PfinderContext.asyncWrapper(task));
        }

        return this.origin.invokeAll(wrappedTasks);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        Collection<Callable<T>> wrappedTasks = new ArrayList();
        Iterator var6 = tasks.iterator();

        while(var6.hasNext()) {
            Callable<T> task = (Callable)var6.next();
            wrappedTasks.add(PfinderContext.asyncWrapper(task));
        }

        return this.origin.invokeAll(wrappedTasks, timeout, unit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        Collection<Callable<T>> wrappedTasks = new ArrayList();
        Iterator var3 = tasks.iterator();

        while(var3.hasNext()) {
            Callable<T> task = (Callable)var3.next();
            wrappedTasks.add(PfinderContext.asyncWrapper(task));
        }

        return this.origin.invokeAny(wrappedTasks);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        Collection<Callable<T>> wrappedTasks = new ArrayList();
        Iterator var6 = tasks.iterator();

        while(var6.hasNext()) {
            Callable<T> task = (Callable)var6.next();
            wrappedTasks.add(PfinderContext.asyncWrapper(task));
        }

        return this.origin.invokeAny(wrappedTasks, timeout, unit);
    }

    public void execute(Runnable command) {
        this.origin.execute(PfinderContext.asyncWrapper(command));
    }
}
