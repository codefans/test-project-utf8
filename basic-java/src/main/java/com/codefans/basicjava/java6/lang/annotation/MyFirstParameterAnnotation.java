package com.codefans.basicjava.java6.lang.annotation;

import java.lang.annotation.*;

/**
 * @author: codefans
 * @date: 2019-09-29 17:45
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFirstParameterAnnotation {

    String value() default "";

    String name() default "";

    boolean required() default true;

    String defaultValue() default "\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n";

}
