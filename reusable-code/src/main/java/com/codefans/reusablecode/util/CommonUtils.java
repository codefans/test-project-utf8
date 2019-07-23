package com.codefans.reusablecode.util;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: codefans
 * @date: 2018-07-27 14:15
 */
public class CommonUtils {

    public static final String PROJECT_ROOT = System.getProperty("user.dir");

    public static String getModuleRoot(String moduleName) {
        return PROJECT_ROOT + File.separator + moduleName;
    }

    public static String getModuleSrcRoot(String moduleName) {
        return getModuleRoot(moduleName) + File.separator + "src";
    }

    public static String getModuleMainRoot(String moduleName) {
        return getModuleSrcRoot(moduleName) + File.separator + "main";
    }

    public static String getModuleTestRoot(String moduleName) {
        return getModuleSrcRoot(moduleName) + File.separator + "test";
    }

    public static String getModuleMainJavaRoot(String moduleName) {
        return getModuleMainRoot(moduleName) + File.separator + "java";
    }

    public static String getModuleTestJavaRoot(String moduleName) {
        return getModuleMainRoot(moduleName) + File.separator + "test";
    }

    public static String getMacDownloadsPath() {
        return "/Users/codefans/Downloads/";
    }


    public static Map<String, Object> bean2map(Object bean) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Map<String, Object> map = new HashMap<String, Object>();

        Class beanCls = bean.getClass();
        Field[] declaredFields = beanCls.getDeclaredFields();
        Field[] fields = beanCls.getFields();

//        System.out.println("declaredFields.length=" + declaredFields.length);
//        System.out.println("fields.length=" + fields.length);
//        System.out.println("(declaredFields.length == fields.length)=" + (declaredFields.length == fields.length));

        Field field = null;
        String fieldName = "";
        String methodName = "";
        Method method = null;

        Object valueObj = null;

        for(int i = 0; i < declaredFields.length; i ++) {
            field = declaredFields[i];
            fieldName = field.getName();
            methodName = constructMethodName(fieldName);

            method = beanCls.getMethod(methodName, null);
            valueObj = method.invoke(bean, null);

//            System.out.println("name=" + fieldName + ", value=" + valueObj);

            map.put(fieldName, valueObj);

        }

        return map;
    }

    public static String constructMethodName(String fieldName) {
        String firstLetter = fieldName.substring(0, 1);
        String suffix = fieldName.substring(1);
        String getMethodName = "get" + firstLetter.toUpperCase() + suffix;
        return getMethodName;
    }

    public static void print(List<String> list) {
        for(String str : list) {
            System.out.println(str);
        }
    }


}
