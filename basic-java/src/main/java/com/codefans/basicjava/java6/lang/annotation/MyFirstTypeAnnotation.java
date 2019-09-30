package com.codefans.basicjava.java6.lang.annotation;

import java.lang.annotation.*;

/**
 * @author: codefans
 * @date: 2019-09-29 14:52
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFirstTypeAnnotation {

    String value() default "";

    String name() default "";

    boolean required() default true;

    String defaultValue() default "\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n";

}
