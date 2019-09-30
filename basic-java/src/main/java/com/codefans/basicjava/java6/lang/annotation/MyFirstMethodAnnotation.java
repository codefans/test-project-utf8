package com.codefans.basicjava.java6.lang.annotation;

import java.lang.annotation.*;

/**
 * @author: codefans
 * @date: 2019-09-30 10:41
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFirstMethodAnnotation {
    String address() default "北京市天安门";
    int postcode() default 10001;
}
