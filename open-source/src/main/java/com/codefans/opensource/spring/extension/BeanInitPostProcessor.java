package com.codefans.opensource.spring.extension;

import com.codefans.opensource.spring.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: codefans
 * @date: 2019-08-01 10:38
 */
public class BeanInitPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("beanName:" + beanName + ",hashcode:" + bean.hashCode());

        if(bean.getClass().equals(Car.class)) {
            Car car = (Car)bean;
            System.out.println("before name=" + car.getName());
            car.setName("car2222");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("bean:" + bean.toString() + ", s:" + beanName);

        return bean;
    }
}
