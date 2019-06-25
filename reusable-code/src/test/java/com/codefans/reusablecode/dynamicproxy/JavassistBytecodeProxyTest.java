package com.codefans.reusablecode.dynamicproxy;

import com.codefans.reusablecode.dynamicproxy.javassist.JavassistBytecodeProxy;
import com.codefans.reusablecode.dynamicproxy.javassist.JavassistProxy;
import org.junit.Test;

/**
 * @author: codefans
 * @date: 2019-06-25 15:31
 */
public class JavassistBytecodeProxyTest extends BaseTest {

    @Test
    public void proxyTest() {

        CountService service = new CountServiceImpl();
//        String newMethodStr = "public int count() { System.out.println('method count() before.'); return delegate.count(); System.out.println('method count() after.');}";
        String newMethodStr = "public int count() { return delegate.count(); }";

        try {
            long time = System.currentTimeMillis();
            CountService javassistProxy = (CountService) JavassistBytecodeProxy.newProxyInstance(service, CountService.class, newMethodStr);
            time = System.currentTimeMillis() - time;
            System.out.println("Create JAVASSIST Bytecode Proxy: " + time + " ms");
            System.out.println("================");

            for (int i = 0; i < 3; i++) {
                test(javassistProxy, "Run JAVASSIST Bytecode Proxy: ");
                System.out.println("----------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
