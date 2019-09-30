package com.codefans.basicjava.java6.lang.annotation;

/**
 * @author: codefans
 * @date: 2019-09-29 17:41
 */
@MyFirstTypeAnnotation(name = "张三")
public class AnnotationHolder {

    @MyFirstConstructorAnnotation(param="构造方法param的值")
    public AnnotationHolder() {

    }

    @MyFirstFieldAnnotation(name = "成员变量注解名字", value = "变量值")
    private String companyName;

    @MyFirstMethodAnnotation(address = "上海外滩", postcode = 10021)
    public String sayHello(@MyFirstParameterAnnotation(name="userName", required = false) String userName) {
        return "hello," + userName;
    }

}
