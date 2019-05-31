package com.codefans.opensource.dubbo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-05-31 14:36:19
 */
public class DubboSPITest {
    @Test
    public void sayHello() throws Exception {
        ExtensionLoader<HelloService> extensionLoader =
                ExtensionLoader.getExtensionLoader(HelloService.class);
        HelloService helloService = extensionLoader.getExtension("helloService");
        helloService.sayHello();

        HelloService hiService = extensionLoader.getExtension("hiService");
        hiService.sayHello();
    }
}
