package com.codefans.basicjava.java6.lang.annotation;

import javax.xml.bind.Element;
import java.lang.annotation.*;

/**
 * @author: codefans
 * @date: 2019-09-30 11:20
 */
@Target({ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFirstConstructorAnnotation {

    String param() default "lalala";

}
