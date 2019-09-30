package com.codefans.basicjava.java6.lang.annotation;

import java.lang.annotation.*;

/**
 * @author: codefans
 * @date: 2019-09-30 11:06
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFirstFieldAnnotation {

    String name() default "haha";
    String value() default "huohuo";

}
