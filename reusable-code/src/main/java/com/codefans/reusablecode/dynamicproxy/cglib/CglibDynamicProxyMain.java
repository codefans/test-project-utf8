package com.codefans.reusablecode.dynamicproxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author: codefans
 * @date: 2019-05-23 10:15:48
 */
public class CglibDynamicProxyMain {

    public static void main(String[] args) {
        CglibDynamicProxyMain main = new CglibDynamicProxyMain();
//        main.cglibProxyBasic();
        main.cglibProxyEnhance();
    }

    public void cglibProxyBasic() {

        CglibService cglibService = new CglibService();
        cglibService.execute("content");

        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/data");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(CglibService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibMethodInterceptor());
        // 创建代理对象
        CglibService proxy= (CglibService)enhancer.create();
        // 通过代理对象调用目标方法
        proxy.execute("我是参数1");

    }

    public void cglibProxyEnhance() {

        Enhancer cglibServiceEnhancer = this.getEnhance(CglibService.class);
        // 创建代理对象
        CglibService enhanceCglibService= (CglibService)cglibServiceEnhancer.create();
        // 通过代理对象调用目标方法
        enhanceCglibService.execute("我是参数1");
        enhanceCglibService.queryResult("我是ID");

        Enhancer helloServiceEnhancer = this.getEnhance(HelloService.class);
        // 创建代理对象
        HelloService enhanceHelloService= (HelloService)helloServiceEnhancer.create();
        // 通过代理对象调用目标方法
        enhanceHelloService.sayHello("王五");
        enhanceHelloService.sayHi("钱八");

    }

    public Enhancer getEnhance(Class proxyClass) {
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(proxyClass);
        // 设置enhancer的回调对象
        enhancer.setCallback(new CglibMethodInterceptor());
        return enhancer;
    }
}
