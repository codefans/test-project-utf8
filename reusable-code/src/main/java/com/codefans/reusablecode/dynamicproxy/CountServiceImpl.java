package com.codefans.reusablecode.dynamicproxy;

/**
 * @author: codefans
 * @date: 2019-06-25 11:39
 */
public class CountServiceImpl implements CountService {
    int count = 0;
    @Override
    public int count() {
        return count++;
    }
}
