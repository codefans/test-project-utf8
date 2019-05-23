package com.codefans.reusablecode.dynamicproxy.jdk;

/**
 * @author: codefans
 * @date: 2019-05-23 09:49:14
 */
public class HelloApiImpl implements HelloApi {

    @Override
    public String sayHello(String content) {
        System.out.println("hello, " + content);
        return "hello, " + content;
    }

}
