/**
 * Copyright (C), 2015-2020, 京东
 * FileName: EagerSingleton
 * Author:   codefans
 * Date:     2020/10/5 12:25
 * Description:
 */
package com.codefans.reusablecode.designpattern.singleton;


/**
 *
 * 饿汉模式单例
 *
 * @author codefans
 * @date 2020/10/05 12:25
 * @since 1.0.0
 */
public class EagerSingleton {

    /**
     *
     */
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {

    }

    /**
     *
     * @return
     */
    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}