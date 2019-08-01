package com.codefans.opensource.spring.handle;

import com.codefans.opensource.spring.parser.SimpleDateFormatBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author: codefans
 * @date: 2019-07-31 18:48
 */
public class AdditionNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("dateformat", new SimpleDateFormatBeanDefinitionParser());
    }

}