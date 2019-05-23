package com.codefans.reusablecode.dynamicproxy.cglib;

/**
 * @author: codefans
 * @date: 2019-05-23 10:03:34
 */
public class CglibService {

    public String execute(String param) {
        System.out.println("param=" + param);
        return "hello, " + param;
    }

}
