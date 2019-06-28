package com.codefans.opensource.dubbo.serialization.java;

import java.io.ObjectStreamClass;

/**
 * @author: codefans
 * @date: 2019-06-28 09:31
 */
public class ClassDescriptorUtils {

    public static ObjectStreamClass readClassDescriptor(String fullClassName) throws ClassNotFoundException {
        Class<?> clazz = loadClass(fullClassName);
        return ObjectStreamClass.lookup(clazz);
    }

    private static Class<?> loadClass(String className) throws ClassNotFoundException {
        ClassLoader mClassLoader = getClassLoader();
        return mClassLoader.loadClass(className);
    }

    public static ClassLoader getClassLoader() {
        return getClassLoader(ClassDescriptorUtils.class);
    }

    public static ClassLoader getClassLoader(Class<?> clazz) {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable var4) {
        }

        if (cl == null) {
            cl = clazz.getClassLoader();
            if (cl == null) {
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable var3) {
                }
            }
        }

        return cl;
    }




}
