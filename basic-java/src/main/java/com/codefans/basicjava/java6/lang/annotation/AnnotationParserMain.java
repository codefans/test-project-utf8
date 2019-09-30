package com.codefans.basicjava.java6.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: codefans
 * @date: 2019-09-29 17:29
 */

public class AnnotationParserMain {

    public static void main(String[] args) {

        AnnotationParserMain annotationParserMain = new AnnotationParserMain();
//        annotationParserMain.parseType();
//        annotationParserMain.parseMethod();
//        annotationParserMain.parseParameter();
//        annotationParserMain.parseField();
        annotationParserMain.parseContructor();



    }

    public void parseType() {
        MyFirstTypeAnnotation myAnnotation = AnnotationHolder.class.getAnnotation(MyFirstTypeAnnotation.class);
        System.out.println("annotation name=" + myAnnotation.name());

        AnnotationHolder annotationHolder = new AnnotationHolder();
        MyFirstTypeAnnotation myTypeAnnotation = annotationHolder.getClass().getAnnotation(MyFirstTypeAnnotation.class);
        System.out.println("myTypeAnnotation=" + myTypeAnnotation.name());

    }

    /**
     * 获取Method方法注解
     */
    public void parseMethod() {


        Method method = null;
        try {

            method = AnnotationHolder.class.getMethod("sayHello", String.class);
            MyFirstMethodAnnotation methodAnnotation = method.getAnnotation(MyFirstMethodAnnotation.class);
            System.out.println("address=" + methodAnnotation.address() + ", postcode=" + methodAnnotation.postcode());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取Parameter参数注解
     */
    public void parseParameter() {

        try {

            Method method = AnnotationHolder.class.getMethod("sayHello", String.class);
            Map<String, String> paramAnnoMap = this.getMethodParamAnnotation(method);

            Iterator<String> keys = paramAnnoMap.keySet().iterator();
            String key = "";
            String val = "";
            while(keys.hasNext()) {
                key = keys.next();
                val = paramAnnoMap.get(key);
                System.out.println("param annotation key:[" + key + "], val:[" + val + "]");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void parseField() {
        try {

            Class cls = AnnotationHolder.class;
            Field field = cls.getDeclaredField("companyName");
            MyFirstFieldAnnotation fieldAnnotation = field.getAnnotation(MyFirstFieldAnnotation.class);
            System.out.println("name=" + fieldAnnotation.name() + ", value=" + fieldAnnotation.value());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    public void parseContructor() {
        try {

            Class cls = AnnotationHolder.class;
            Constructor constructor = cls.getConstructor(null);
            MyFirstConstructorAnnotation constructorAnnotation = (MyFirstConstructorAnnotation)constructor.getAnnotation(MyFirstConstructorAnnotation.class);
            System.out.println("param=" + constructorAnnotation.param());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取给 "方法参数" 进行注解的值
     *
     * @param method 要获取参数名的方法
     * @return 按参数顺序排列的参数名列表
     */
    public static Map<String, String> getMethodParamAnnotation(Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations == null || parameterAnnotations.length == 0) {
            return null;
        }
        Map<String, String> paramInfoMap = new HashMap<String, String>();
        for (Annotation[] annotationArr : parameterAnnotations) {
            for (Annotation annotation : annotationArr) {
                if (annotation instanceof MyFirstParameterAnnotation) {
                    MyFirstParameterAnnotation param = (MyFirstParameterAnnotation) annotation;
                    paramInfoMap.put(param.name(), param.value());
                }
            }
        }
        return paramInfoMap;
    }


}
