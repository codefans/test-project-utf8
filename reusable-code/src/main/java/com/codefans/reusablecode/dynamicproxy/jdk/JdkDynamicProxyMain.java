package com.codefans.reusablecode.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author: codefans
 * @date: 2019-05-23 09:55:08
 */
public class JdkDynamicProxyMain {

    public static void main(String[] args) {
        JdkDynamicProxyMain main = new JdkDynamicProxyMain();
        main.jdkProxy();
    }

    public void jdkProxy() {

        HelloApi helloApi = new HelloApiImpl();
        String response = helloApi.sayHello("zhangsan");
//        System.out.println("response=" + response);

        HelloApi proxyHelloApi = (HelloApi) Proxy.newProxyInstance(helloApi.getClass().getClassLoader(), helloApi.getClass().getInterfaces(), new HelloApiInvocationHandler(helloApi));
        String proxyResponse = proxyHelloApi.sayHello("李四");
//        System.out.println("proxyResponse=" + proxyResponse);
    }

}
