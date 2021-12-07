package com.codefans.reusablecode.designpattern.singleton;


import java.lang.reflect.Constructor;

/**
 * 反射破坏单例
 * 怎么破坏单例模式和怎么防止单例模式被破坏
 * http://www.justdojava.com/2019/08/21/Java-single-destroy-prevent/
 *
 * @author: codefans
 * @Date: 2021/12/07 10:19
 * @since: 1.0.0
 */
public class ReflectDestroySingleton {

    public static void main(String[] args) {
        try {
            //很无聊的情况下，进行破坏
            Class<?> clazz = StaticInnerClass.class;
            //通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //因为要访问私有的构造方法，这里要设为true，相当于让你有权限去操作
            c.setAccessible(true);

            StaticInnerClass instance = StaticInnerClass.getInstance();

            //暴力初始化
            Object o1 = c.newInstance();
            //调用了两次构造方法，相当于 new 了两次
            Object o2 = c.newInstance();
            //这里输出结果为false
            System.out.println("(o1 == o2)=" + (o1 == o2));

            System.out.println("(o1 == instance)=" + (o1 == instance));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}