package com.codefans.opensource.spring;

import com.codefans.opensource.spring.bean.Component;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: codefans
 * @date: 2019-08-01 09:19
 */
public class XmlExtensionTest {

    @Test
    public void test() {

        String[] configLocaltions = new String[]{
            "spring/appCtx.xml"
        };
        ApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocaltions);
        DateFormat dateFormat = (DateFormat) appCtx.getBean("defaultDateFormat");
        System.out.println(dateFormat.format(new Date()));

        Component component = (Component)appCtx.getBean("bionic-family");
        this.print(component);



    }

    public void print(Component component) {
        System.out.println("familyName=" + component.getName());
        List<Component> parents = component.getComponents();
        for(Component parent : parents) {
            System.out.println("parents=" + parent.getName());
            List<Component> childrenList = parent.getComponents();
            for(Component children : childrenList) {
                System.out.println("children=" + children.getName());

            }
        }
    }


}
