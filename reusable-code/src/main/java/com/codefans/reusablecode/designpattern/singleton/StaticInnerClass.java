package com.codefans.reusablecode.designpattern.singleton;

import java.io.Serializable;

/**
 * @author: codefans
 * @date: 2018-10-26 16:48
 * 单例模式的双重检查
 * https://www.jianshu.com/p/45885e50d1c4
 *
 * 原理：
 *     JVM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。
 *     在执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化。
 *
 */
public class StaticInnerClass {

    /**
     * 防止反射破坏单例
     */
    private StaticInnerClass() {
        if(getInstance() != null) {
            throw new IllegalStateException("不能重复创建实例!!!");
        }
    }

    private static class InstanceHolder{
        public static StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance(){
        /**
         * 这里将导致InstanceHolder类被初始化
         */
        return InstanceHolder.instance;
    }


}
