package com.codefans.opensource.spring.extension;

import com.codefans.opensource.spring.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author: codefans
 * @date: 2019-08-01 11:17
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Car car = (Car)beanFactory.getBean("car");
        System.out.println("MyBeanFactoryPostProcessor -> car:" + car.getName());
    }
}
