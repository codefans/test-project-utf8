package com.codefans.opensource.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author: codefans
 * @date: 2019-05-31 14:48:09
 */
@SPI
public interface HelloService {
    void sayHello();
}
