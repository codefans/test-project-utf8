package com.codefans.opensource.dubbo.spi;

/**
 * @author: codefans
 * @date: 2019-05-31 14:49:34
 */
public class HiServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am HiServiceImpl.");
    }
}
