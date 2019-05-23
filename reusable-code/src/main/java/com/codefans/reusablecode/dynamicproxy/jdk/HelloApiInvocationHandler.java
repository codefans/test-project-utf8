package com.codefans.reusablecode.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: codefans
 * @date: 2019-05-23 09:50:50
 */
public class HelloApiInvocationHandler implements InvocationHandler {

    private HelloApi helloApi;
    public HelloApiInvocationHandler(HelloApi helloApi) {
        this.helloApi = helloApi;
    }

    public void before() {
        System.out.println("proxy before method.");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object resultObj = null;
        before();
        resultObj = method.invoke(helloApi, args);
        after();
        return resultObj;
    }

    public void after() {
        System.out.println("proxy after method.");
    }


}
