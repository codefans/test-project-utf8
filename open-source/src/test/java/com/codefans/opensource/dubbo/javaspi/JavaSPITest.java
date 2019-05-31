package com.codefans.opensource.dubbo.javaspi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author: codefans
 * @date: 2019-05-31 14:00:54
 */
public class JavaSPITest {
    @Test
    public void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
