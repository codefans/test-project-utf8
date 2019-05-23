package com.codefans.reusablecode.dynamicproxy.cglib;

/**
 * @author: codefans
 * @date: 2019-05-23 10:22:02
 */
public class HelloService {

    public String sayHello(String personName) {
        System.out.println("hello, " + personName);
        return "hello, " + personName;
    }

}
