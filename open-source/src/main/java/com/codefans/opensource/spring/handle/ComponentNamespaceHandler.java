package com.codefans.opensource.spring.handle;

import com.codefans.opensource.spring.parser.ComponentBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author: codefans
 * @date: 2019-08-01 14:18
 */
public class ComponentNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("component", new ComponentBeanDefinitionParser());
    }

}
