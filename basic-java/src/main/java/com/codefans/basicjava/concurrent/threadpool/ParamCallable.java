package com.codefans.basicjava.concurrent.threadpool;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.codefans.basicjava.dto.ResultDto;

/**
 * @author: codefans
 * @date: 2019-07-04 11:56
 */
public class ParamCallable implements Callable<ResultDto> {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Override
    public ResultDto call() throws Exception {

        ResultDto resultDto = null;

        lock.lock();
        try {

            resultDto = new ResultDto();
            resultDto.setName(Thread.currentThread().getName());
            Thread.sleep(5 * 1000);
            resultDto.setDate(new Date().toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return resultDto;
    }
}
