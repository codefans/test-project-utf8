package com.codefans.interview.concurrent.onebyone;

/**
 * @author: codefans
 * @date: 2019-10-11 14:29
 */
public interface RunOneByOneApi {

    public void first(Runnable printFirst) throws InterruptedException;

    public void second(Runnable printSecond) throws InterruptedException;

    public void third(Runnable printThird) throws InterruptedException;

}
